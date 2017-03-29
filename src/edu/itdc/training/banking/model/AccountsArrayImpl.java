package edu.itdc.training.banking.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.itdc.training.banking.util.CopyUtil;
import edu.itdc.training.banking.util.exceptions.DuplicateAccountException;
import edu.itdc.training.banking.util.exceptions.IllegalAmountException;
import edu.itdc.training.banking.util.exceptions.InsufficientFundException;

public class AccountsArrayImpl implements AccountsDAO {
	private static final int DEFAULT_SIZE = 10; 
	private BankAccount accounts[];
	private int size = 0;
	private static AccountsArrayImpl instance;
	
	private AccountsArrayImpl() {
		accounts = new BankAccount[DEFAULT_SIZE];
	}
	
	private AccountsArrayImpl(int initSize) {
		accounts = new BankAccount[initSize];
	}
	
	public static AccountsArrayImpl getInstance() {
		if(instance == null) {
			return new AccountsArrayImpl(); 
		} else {
			return instance;
		}
	}
	
	public static AccountsArrayImpl getInstance(int initSize) {
		if(instance == null) {
			return new AccountsArrayImpl(initSize); 
		} else {
			return instance;
		}
	}

	/*
	 * Add new Accounts at the end.  
	 * Assume no accounts will be deleted to produce null between records
	 */
	@Override
	public synchronized boolean addAccount(BankAccount account) throws DuplicateAccountException {
		if(getAccount(account.getAccountNo()) != null ) {
			throw new DuplicateAccountException();
		}
		if( size >= accounts.length ) {
			expand();
		}
		accounts[size++] = CopyUtil.clone(account);  // make a defensive copy of the object, before adding to list
		return true;
	}
	
	/*
	 * Grow the array size to size + 1/3 of original size 
	 */
	public synchronized void expand() {
		BankAccount newAccounts[] = Arrays.copyOf(accounts, size + size * 1/3);  
		accounts = newAccounts;											 
	}

	@Override
	public BankAccount findAccount(String accountNo) {
		// TODO: validate accountNo format 
		BankAccount account = null;
		for(BankAccount acc: accounts) {
			if(acc == null) {  // account not found when NULL is reach. 
				break;
			}
			if(acc.getAccountNo() == accountNo) {
				account = CopyUtil.clone(acc);  // return only an exact copy of the account.
				break;
			}
		}
		return account;
	}

	// For internal use only, get reference to BankAccount
	private BankAccount getAccount(String accountNo) {
		// TODO: validate accountNo format 
		BankAccount account = null;
		for(BankAccount acc: accounts) {
			if(acc == null) {  // account not found when NULL is reach. 
				break;
			}
			if(acc.getAccountNo() == accountNo) {
				account = acc;  
				break;
			}
		}
		return account;
	}
	
	@Override
	public synchronized boolean closeAccount(String accountNo) {
		boolean optSuccess = false;
		for(BankAccount acc: accounts) {
			if(acc == null) {
				break;
			}
			if(acc.getAccountNo() == accountNo) {
				acc.setStatus(AccountStatus.CLOSE);
				optSuccess = true;
				break;
			}
		}
		return optSuccess;
	}
	
	// Return a copy of the original array.
	// prevent modification of internal array values
	public BankAccount[] getAllAccounts() {
		// TODO: implement this as deep copy
		return accounts.clone();
	}
	
	public int size() {
		return size;
	}
	
	public BankAccount[] getAllOpenAccounts() {
		List<BankAccount> list = Arrays.asList(accounts);
		list.removeAll(Collections.singleton(null));
		
		BankAccount newList[] = new BankAccount[list.size()];
		int counter = 0;
		for(BankAccount acc: list) {
			newList[counter++] = CopyUtil.clone(acc);   
		}
		return newList;	
	}

	@Override
	public synchronized boolean deposit(String accountNo, double amount) 
			throws IllegalAmountException {
		
		BankAccount account = getAccount(accountNo);
		if( account != null && account.isOpen()) {
			account.deposit(amount);
			return true;
		}
		return false;
	}

	@Override
	public synchronized boolean withdraw(String accountNo, double amount) 
			throws IllegalAmountException, InsufficientFundException {
		
		BankAccount account = getAccount(accountNo);
		if( account != null && account.isOpen()) {
			account.withdraw(amount);
			return true;
		}
		return false;
	}
}
