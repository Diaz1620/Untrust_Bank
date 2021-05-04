package com.yadiel.untrust_bank.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.yadiel.untrust_bank.models.Account;
import com.yadiel.untrust_bank.models.User;
import com.yadiel.untrust_bank.models.UserAccount;
import com.yadiel.untrust_bank.repositories.AccountRepository;
import com.yadiel.untrust_bank.repositories.UserAccountRepository;
import com.yadiel.untrust_bank.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserAccountRepository userAccountRepository;
    
    public UserService(UserRepository userRepository, AccountRepository accountRepository, UserAccountRepository userAccountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.userAccountRepository = userAccountRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        user.setEmail(user.getEmail().toLowerCase());
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    public Account getAccountById(Long id ) {
    	return this.accountRepository.findById(id).orElse(null);
    }
    
    
    public UserAccount createAssociation(UserAccount userAccount) {
    	return this.userAccountRepository.save(userAccount);
    }
    
    public List<Account> findAllAccounts(){
    	return (List<Account>)this.accountRepository.findAll();
    }
    
    
//    public Account addToBalance(Long id, double amount) {
//    	Account acct = getAccountById(id);
//    	double balance = acct.getBalance();
//    	acct.setBalance(balance += amount);
//    	return this.accountRepository.save(acct);
//    }
    
    
//    public void deposit(Long id, double amount) {
//    	Account account = this.getAccountById(id);
//    	
//		double newBalance = account.getBalance() - amount;
//		account.setBalance(newBalance);
//		this.accountRepository.save(account);
//    }
    
    public Account updateAcct(Account account) {
    	return this.accountRepository.save(account);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
