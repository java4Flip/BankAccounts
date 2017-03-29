package edu.itdc.training.banking.util.exceptions;

public class IllegalAmountException extends Exception {
	private static final long serialVersionUID = 6860069876363800787L;
	
	public IllegalAmountException() {}
	public IllegalAmountException(String message) {
		super(message);
	}
}
