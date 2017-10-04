package br.ufc.dc.tpii.bank.control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.*;
import br.ufc.dc.tpii.bank.control.exception.BankTransactionException;
import br.ufc.dc.tpii.bank.persistence.AccountVector;

public class BankControllerTest {

	private BankController bank;
	private OrdinaryAccount ordAccount;
	private SavingsAccount savAccount;
	
	@Before
	public void setUp() throws Exception {
		bank = new BankController(new AccountVector());
		ordAccount = new OrdinaryAccount("123A");
		savAccount = new SavingsAccount("123C");
	}

	@Test
	public void testDoTransfer() {
		try {
			bank.addAccount(ordAccount);
			bank.addAccount(savAccount);
			bank.doCredit("123A", 10);
			assertEquals("Erro na op", 10.0, ordAccount.getBalance(), 0.0);
			bank.doTransfer("123A", "123C", 10);
			assertEquals("Erro na op", 0.0, ordAccount.getBalance(), 0.0);
			assertEquals("Erro na op", 10.0, savAccount.getBalance(), 0.0);
		} catch (BankTransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
