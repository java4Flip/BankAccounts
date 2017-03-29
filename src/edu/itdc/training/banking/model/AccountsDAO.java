package edu.itdc.training.banking.model;

import edu.itdc.training.banking.util.exceptions.DuplicateAccountException;
import edu.itdc.training.banking.util.exceptions.IllegalAmountException;
import edu.itdc.training.banking.util.exceptions.InsufficientFundException;

public interface AccountsDAO {
	public boolean addAccount(BankAccount account) throws DuplicateAccountException;
	public BankAccount findAccount(String accountNo);
	public boolean closeAccount(String accountNo);
	
	public boolean deposit(String accountNo, double amount) 
			throws IllegalAmountException;
	public boolean withdraw(String accountNo, double amount)  
			throws IllegalAmountException, InsufficientFundException ;
}
