package edu.itdc.training.banking.model;

import edu.itdc.training.banking.util.exceptions.IllegalAmountException;
import edu.itdc.training.banking.util.exceptions.InsufficientFundException;

public final class CheckingAccount extends BankAccount {
	private double overdraftProtection;
	
	public CheckingAccount(){}
	
	public CheckingAccount(String accountNo, String accountName) {
		super(accountNo, accountName);
	}
	
	public CheckingAccount(String accountNo, String accountName, double initBalance, double overdraftProtection) {
		super(accountNo, accountName, initBalance);
		this.overdraftProtection = overdraftProtection;
	}
	
	public boolean withdraw(double amount) throws IllegalAmountException, InsufficientFundException {
		if( amount <= 0 ) {
			throw new IllegalAmountException("Amount cannot be zero or less than zero.");
		}
		
		if( balance <= 0 || amount > (balance + overdraftProtection) ) {
			throw new InsufficientFundException("Balance insufficient.", balance, amount);
		} else {
			balance -= amount;
		}
		return true;
	}

	public double getOverdraftProtection() {
		return overdraftProtection;
	}
}
