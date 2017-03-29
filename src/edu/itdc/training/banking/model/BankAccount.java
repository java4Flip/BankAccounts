package edu.itdc.training.banking.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.itdc.training.banking.util.exceptions.IllegalAmountException;
import edu.itdc.training.banking.util.exceptions.InsufficientFundException;

public abstract class BankAccount implements Cloneable {
	private String accountNo;
	private String accountName;
	protected double balance;
	private AccountStatus status = AccountStatus.OPEN;
	
	public BankAccount(){}
	
	public BankAccount(String accountNo, String accountName) {
		this.accountNo = accountNo;
		this.accountName = accountName;
	}
	
	public BankAccount(String accountNo, String accountName, double initBalance) {
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amount) throws IllegalAmountException {
		if(amount <= 0) {
			throw new IllegalAmountException();
		}
		balance += amount;
		return true;
	}
	
	public boolean withdraw(double amount) throws IllegalAmountException, InsufficientFundException {
		if( amount <= 0 ) {
			throw new IllegalAmountException("Amount cannot be zero or less than zero.");
		}
		
		if( amount > balance ) {
			throw new InsufficientFundException("Balance insufficient.", balance, amount);
		} else {
			balance -= amount;
		}
		return true;
	}
	
	public void changeStatus(AccountStatus status) {
		this.status = status;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}
	
	public boolean isOpen() {
		return (status == AccountStatus.OPEN);
	}
	
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
}
