package br.ufc.dc.tpii.bank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;

public class SpecialAccountTest {

	private SpecialAccount account;
	
	@Before
	public void setUp() throws Exception {
		this.account = new SpecialAccount("123D");
	}
	
	@Test
	public void testCredit50AndDebit30(){
		try {
			account.credit(50);
			account.earnBonus();
			assertEquals("Erro na op", 50.5, account.getBalance(), 0.0);
			account.debit(30);
			assertEquals("Erro na op", 20.5, account.getBalance(), 0.0);
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
		//fail("Not yet implemented");
	}

	@Test
	public void testEarnBonus() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBonus() {
		//fail("Not yet implemented");
	}

}
