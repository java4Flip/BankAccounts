package edu.itdc.training.banking.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.itdc.training.banking.model.AccountsArrayImpl;
import edu.itdc.training.banking.model.BankAccount;
import edu.itdc.training.banking.model.CheckingAccount;
import edu.itdc.training.banking.model.SavingsAccount;
import edu.itdc.training.banking.util.exceptions.DuplicateAccountException;

public class AccountsArrayImplTestNewAccounts {

	@Test
	public void testForNewAccountsList() {
		AccountsArrayImpl accounts = AccountsArrayImpl.getInstance();
		assertTrue("Guarantee new list empty", accounts.size() == 0);
	}
	
	@Test
	public void testForNewAccountsCountRecorded() throws DuplicateAccountException {
		AccountsArrayImpl accounts = AccountsArrayImpl.getInstance();
		accounts.addAccount(new SavingsAccount("1001","Jose Rizal", 15000, .05));
		accounts.addAccount(new CheckingAccount("2001","Jose Rizal", 15000, 5000));
		accounts.addAccount(new SavingsAccount("1002","Jose Rizal", 15000, .05));
		
		assertEquals(accounts.size(), 3);
	}
	
	@Test
	public void testForSearchOfAccount() throws DuplicateAccountException {
		AccountsArrayImpl accounts = AccountsArrayImpl.getInstance();
		accounts.addAccount(new SavingsAccount("1001","Jose Rizal", 15000, .05));
		accounts.addAccount(new CheckingAccount("2001","Maria Clara", 50000, 5000));
		accounts.addAccount(new SavingsAccount("1002","Pedro Monteclaro", 124000, .10));
		
		BankAccount acc = accounts.findAccount("1001");
		assertEquals(acc.getAccountNo(), "1001");
		assertEquals(acc.getAccountName(), "Jose Rizal");
		assertEquals(acc.getBalance(), 15000, 0.0005);
		
		acc = accounts.findAccount("2001");
		assertEquals(acc.getAccountNo(), "2001");
		assertEquals(acc.getAccountName(), "Maria Clara");
		assertEquals(acc.getBalance(), 50000, 0.0005);
		
		acc = accounts.findAccount("1002");
		assertEquals(acc.getAccountNo(), "1002");
		assertEquals(acc.getAccountName(), "Pedro Monteclaro");
		assertEquals(acc.getBalance(), 124000, 0.0005);
		
		acc = accounts.findAccount("1003");
		assertEquals(acc, null);
	}
	
	@Test void testForRetrievingAllAccounts() throws DuplicateAccountException {
		AccountsArrayImpl accounts = AccountsArrayImpl.getInstance();
		accounts.addAccount(new SavingsAccount("1001","Jose Rizal", 15000, .05));
		accounts.addAccount(new CheckingAccount("2001","Maria Clara", 50000, 5000));
		accounts.addAccount(new SavingsAccount("1002","Pedro Monteclaro", 124000, .10));
		
		BankAccount list[] = accounts.getAllAccounts();	
	}
}
