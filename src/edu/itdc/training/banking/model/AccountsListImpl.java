package edu.itdc.training.banking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.itdc.training.banking.util.exceptions.IllegalAmountException;
import edu.itdc.training.banking.util.exceptions.InsufficientFundException;

public class AccountsListImpl implements AccountsDAO {
	private ArrayList<BankAccount> accounts;
	private static AccountsListImpl instance;

	private AccountsListImpl() {
		accounts = new ArrayList<>();
	}
	
	public static AccountsListImpl getInstance() {
		if(instance == null) {
			return new AccountsListImpl();
		} else {
			return instance;
		}
	}
	
	@Override
	public boolean addAccount(BankAccount account) {
		
		return false;
	}

	@Override
	public BankAccount findAccount(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// To prevent caller from modifying underlying source data
	public List<BankAccount> getAllAccounts() {
		return Collections.unmodifiableList(accounts);
	}

	@Override
	public boolean deposit(String accountNo, double amount) throws IllegalAmountException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(String accountNo, double amount) throws IllegalAmountException, InsufficientFundException {
		// TODO Auto-generated method stub
		return false;
	}
}
