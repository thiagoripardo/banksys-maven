package br.ufc.dc.tpii.bank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;

public class TaxAccountTest {

	private TaxAccount account;
	
	@Before
	public void setUp() throws Exception {
		account = new TaxAccount("123B");
	}

	@Test
	public void testCredit50AndDebit30(){
		try {
			account.credit(50);
			assertEquals("Erro na op", 50, account.getBalance(), 0.0);
			account.debit(30);
			assertEquals("Erro na op", 19.97, account.getBalance(), 0.0);
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDebit() {
		//fail("Not yet implemented");
	}

	@Test
	public void testTaxAccount() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCredit() {
		//fail("Not yet implemented");
	}

}
