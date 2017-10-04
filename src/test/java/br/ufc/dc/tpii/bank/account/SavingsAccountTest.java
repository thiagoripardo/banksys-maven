package br.ufc.dc.tpii.bank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;

public class SavingsAccountTest {
	
	private SavingsAccount account;
	
	@Before
	public void setUp() throws Exception {
		this.account = new SavingsAccount("123C");
	}

	@Test
	public void testCredit50AndDebit30(){
		try {
			account.credit(50.00);
			account.earnInterest();
			assertEquals("Erro na op", 50.05, account.getBalance(), 0.0);
			account.debit(30.00);
			assertEquals("Erro na op", 20.05, account.getBalance(), 0.001);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	public void testEarnInterest() {
		try {
			account.credit(50.00);
			account.earnInterest();
			assertEquals("Erro na op", 50.05, account.getBalance(), 0.0);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
