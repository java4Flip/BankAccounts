package edu.itdc.training.banking.util.exceptions;

public class InsufficientFundException extends Exception {
	private static final long serialVersionUID = -9015555836711524082L;
	private final double balance;
	private final double amount;

	public InsufficientFundException(String message, double balance, double amount) {
		super(message);
		this.balance = balance;
		this.amount = amount;
	}
	
	public String getMessage() {
		return getMessage() + " Current balance: " + balance + " Amount: " + amount;
	}
}
