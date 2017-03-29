package edu.itdc.training.banking.app;

import java.util.Scanner;

import edu.itdc.training.banking.model.BankAccount;

public class BankConsole {
	public static final char OPEN_NEWACCOUNTS = '1';
	public static final char MAKE_DEPOSIT     = '2';
	public static final char MAKE_WITHDRAWAL  = '3';
	public static final char CLOSE_ACCOUNT    = '4';
	public static final char MAKE_REPORTS     = '5';
	public static final char EXIT_APP         = '6';
	
	private static Scanner sc = new Scanner(System.in);
	
	public static char menu() {
		System.out.println("MiniBank Console");
		System.out.println("1. New Accounts");
		System.out.println("2. Deposit");
		System.out.println("3. Withdrawal");
		System.out.println("4. Close Account");
		System.out.println("5. Reports");
		System.out.println("6. Exit");
		System.out.print("Enter option no.: ");
		char option = sc.nextLine().charAt(0);
		return option;
	}
	
	public static BankAccount openNewAccount() {
	    return null;
	}
}
