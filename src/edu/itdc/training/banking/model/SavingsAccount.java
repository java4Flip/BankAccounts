package edu.itdc.training.banking.model;

public final class SavingsAccount extends BankAccount {
	private double initRate;
	
	public SavingsAccount() {};
	
	public SavingsAccount(String accountNo, String accountName) {
		super(accountNo, accountName);
	}
	
	public SavingsAccount(String accountNo, String accountName, double initBalance, double initRate) {
		super(accountNo, accountName, initBalance);
		this.initRate = initRate;
	}

	public double getInitRate() {
		return initRate;
	}
}
