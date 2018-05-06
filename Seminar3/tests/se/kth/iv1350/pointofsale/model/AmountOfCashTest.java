package se.kth.iv1350.pointofsale.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountOfCashTest {

	private AmountOfCash 	   amountOfCashNoArg; 
	private AmountOfCash      amountOfCashArgNine;
	

	@BeforeEach
	public void setUp() throws Exception {
		amountOfCashNoArg    = new AmountOfCash();
		amountOfCashArgNine = new AmountOfCash(9);
	}

	@AfterEach
	void tearDown() throws Exception {
		amountOfCashNoArg = null;
		amountOfCashArgNine = null;
	}

	@Test
	public void testNotEqualsNull() {
		System.out.print("Test for NotEqualNull"+"\n");
		Object nullObject = null;
		boolean expResult = false;
		boolean result = amountOfCashNoArg.equals(nullObject);
		assertEquals("Amount instance equal to null.", expResult, result);
	
	}
	@Test
	public void testNotEqualUsingNoArgConstr() { 
		System.out.print("Test for NotEqualUsingNoArgConstr"+"\n");
		boolean expResult = false;
		boolean result = 	amountOfCashNoArg.equals(amountOfCashArgNine);
	    assertEquals("Amount instances with different states "
	                 + "are equal.", expResult, result);
	}
	
	@Test
	public void testNotEqual() {
	System.out.print("Test for NotEqual"+"\n");
	int amountOfOther = 4;
	AmountOfCash other = new AmountOfCash(amountOfOther);
	}

}
