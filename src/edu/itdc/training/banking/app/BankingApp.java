package edu.itdc.training.banking.app;

import edu.itdc.training.banking.model.AccountsArrayImpl;
import edu.itdc.training.banking.model.AccountsDAO;
import edu.itdc.training.banking.model.BankAccount;
import edu.itdc.training.banking.util.exceptions.DuplicateAccountException;

public class BankingApp {
	private static AccountsDAO dao;
	
	public static void main(String[] args) {
		dao = AccountsArrayImpl.getInstance();
		
		boolean lContinue = true;
		while(lContinue) {
			switch(BankConsole.menu()) {
			case BankConsole.OPEN_NEWACCOUNTS: 
				openNewAccount(); break;
			case BankConsole.MAKE_DEPOSIT:
				makeDeposit(); break;
			case BankConsole.MAKE_WITHDRAWAL:
				makeWithdrawal(); break;
			case BankConsole.CLOSE_ACCOUNT:
				closeAccount(); break;
			case BankConsole.MAKE_REPORTS:
				makeReports(); break;
			case BankConsole.EXIT_APP:
				lContinue = false;
			}
		}
		System.out.println("End of program...");
	}
	
	public static void openNewAccount() {
		BankAccount acc = BankConsole.openNewAccount();
		if( acc != null ) {
			try {
				dao.addAccount(acc);
			} catch(DuplicateAccountException ex) {
				
			}
		}
	}
	
	public static void makeDeposit() {
		System.out.println("\nUnder construction...");
	}
	
	public static void makeWithdrawal() {
		System.out.println("\nUnder construction...");
	}
	
	public static void makeReports() {
		System.out.println("\nUnder construction...");
	}
	
	public static void closeAccount() {
		System.out.println("\nUnder construction...");
	}
}
