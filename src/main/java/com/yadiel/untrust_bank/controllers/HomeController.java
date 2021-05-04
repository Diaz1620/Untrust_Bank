package com.yadiel.untrust_bank.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yadiel.untrust_bank.models.Account;
import com.yadiel.untrust_bank.models.User;
import com.yadiel.untrust_bank.models.UserAccount;
import com.yadiel.untrust_bank.services.UserService;
import com.yadiel.untrust_bank.validation.UserValidator;

@Controller
public class HomeController {
	
	private final UserService userserv;
	private final UserValidator userValidator;
	
	public HomeController(UserService userserv, UserValidator userValidator) {
		super();
		this.userserv = userserv;
		this.userValidator = userValidator;
	}

	@GetMapping("/")
	public String greeting(@ModelAttribute("user") User user) {
		
		return "login.jsp";
	}
	
	@GetMapping("/register")
	public String regform(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";
		}
		
		Account check = this.userserv.getAccountById((long) 1);
		Account saving = this.userserv.getAccountById((long) 2);
		
		User u = this.userserv.registerUser(user);
		
		session.setAttribute("userid", u.getId());
		
		
		UserAccount checkaccount = new UserAccount(u, check);
		UserAccount saveaccount = new UserAccount(u, saving);
		
		
		this.userserv.createAssociation(checkaccount);
		this.userserv.createAssociation(saveaccount);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		Long id = (Long)session.getAttribute("userid");
		User loggedinuser = this.userserv.findUserById(id);
		
		model.addAttribute("loggedinuser", loggedinuser);
		return "dashboard.jsp";
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
		
		Boolean isLegit = this.userserv.authenticateUser(email, password);
		
		if(isLegit) {
			User user = this.userserv.findByEmail(email);
			session.setAttribute("userid", user.getId());
			return "redirect:/dashboard";
		}
		redirectAttributes.addFlashAttribute("error", "Invalid login attempt");
		return "redirect:/";
	}
	
	@GetMapping("/deposit")
	public String depositPage(@ModelAttribute("account") Account account, Model model) {
		
		model.addAttribute("allaccounts", this.userserv.findAllAccounts());
		
		return "deposit.jsp";
	}
	
	@PostMapping("/makedeposit")
	public String depositIt(@RequestParam(value="selectedAcct") Long acctId, @RequestParam(value="amount") double amount, HttpSession session) {
		Long id = (Long)session.getAttribute("userid");
		User loggedinuser = this.userserv.findUserById(id);
		
		Account acct = this.userserv.getAccountById(acctId);
		
		
		double balance = acct.getBalance();
		acct.setBalance(balance += amount);
		this.userserv.updateAcct(acct);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/withdraw")
	public String depositPage(@ModelAttribute("account") Account account, Model model) {
		
		model.addAttribute("allaccounts", this.userserv.findAllAccounts());
		
		return "deposit.jsp";
	}
	
	
}
