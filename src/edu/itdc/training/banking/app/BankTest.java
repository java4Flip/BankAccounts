package edu.itdc.training.banking.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import edu.itdc.training.banking.model.BankAccount;
import edu.itdc.training.banking.model.CheckingAccount;
import edu.itdc.training.banking.model.SavingsAccount;
import edu.itdc.training.banking.util.CopyUtil;

public class BankTest {
	@Test
	public void whenCloningBankAccount_verifyNotSameObject() {
		BankAccount acc1 = new SavingsAccount("1001", "Paulino Alcantara", 10000, .01);
		assertNotSame(acc1, CopyUtil.clone(acc1));
		
		BankAccount acc2 = new CheckingAccount("2002", "Teresa Magbanua", 45000, 5000);
		assertNotSame(acc2, CopyUtil.clone(acc2));	
	}
	
	@Test
	public void whenCloningBankAccount_verifyFieldsCopied() {
		BankAccount acc1 = new SavingsAccount("1001", "Paulino Alcantara", 10000, .01);
		BankAccount copy1 = CopyUtil.clone(acc1);
		
		assertEquals(acc1.getAccountName(), copy1.getAccountName());
		assertEquals(acc1.getAccountNo(), copy1.getAccountNo());
		assertEquals(acc1.getBalance(), copy1.getBalance(), 0.000001);
		assertEquals(((SavingsAccount)acc1).getInitRate(), ((SavingsAccount) copy1).getInitRate(), 0.000001);
		
		BankAccount acc2 = new CheckingAccount("2002", "Teresa Magbanua", 45000, 5000);
		BankAccount copy2 = CopyUtil.clone(acc2);
		
		assertEquals(acc2.getAccountName(), copy2.getAccountName());
		assertEquals(acc2.getAccountNo(), copy2.getAccountNo());
		assertEquals(acc2.getBalance(), copy2.getBalance(), 0.000001);
		assertEquals(((CheckingAccount) acc2).getOverdraftProtection(), 
				((CheckingAccount) copy2).getOverdraftProtection(), 0.000001);
	}
}
