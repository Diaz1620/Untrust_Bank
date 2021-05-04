package com.yadiel.untrust_bank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Must have account name")
	private String type;
	
	@Min(value=1, message="Value must be more than  1")
	private double balance;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_accounts",
    		joinColumns = @JoinColumn(name = "account_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;
	
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public Account() {
    	
    }
    
    
	public Account(@NotEmpty(message = "Must have account name") String type,
			@Min(value = 1, message = "Value must be more than  1") double balance, List<User> users) {
		super();
		this.type = type;
		this.balance = balance;
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
