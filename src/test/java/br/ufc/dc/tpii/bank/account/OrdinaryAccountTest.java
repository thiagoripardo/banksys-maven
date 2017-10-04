package br.ufc.dc.tpii.bank.account;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.OrdinaryAccount;
import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;

public class OrdinaryAccountTest {

	private OrdinaryAccount account;
	
	@Before
	public void setUp() throws Exception {
		account = new OrdinaryAccount("123A");
	}
	
	@Test
	public void testCredit50AndDebit30(){
		try {
			account.credit(50);
			assertEquals("Erro na op", 50, account.getBalance(), 0.0);
			account.debit(30);
			assertEquals("Erro na op", 20, account.getBalance(), 0.0);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	public void testCredit() {
		try {
			account.credit(50);
			assertEquals("Erro na op", 50, account.getBalance(), 0.0);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			account = new OrdinaryAccount("123A");
		}
		
	}

	@Test(expected = InsufficientFundsException.class)
	public void testDebit() throws InsufficientFundsException {
		try {
			account.debit(20);
			assertEquals("Erro na op", 20, account.getBalance(), 0.0);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			account = new OrdinaryAccount("123A");
		}
		
	}
}
