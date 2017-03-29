package edu.itdc.training.banking.util.exceptions;

public class DuplicateAccountException extends Exception {
	private static final long serialVersionUID = 3773312098963489606L;

	public DuplicateAccountException() {
		super();
	}

	public DuplicateAccountException(String message) {
		super(message);
	}
	
}
