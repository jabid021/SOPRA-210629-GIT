package demoJunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculatrice {

	private Calculatrice c;

	@Before
	public void initCalculatrice() {
		c = new Calculatrice();
	}

	@After
	public void apresChaqueTest() {

	}

	@BeforeClass
	public static void avantLePremierTest() {

	}

	@AfterClass
	public static void apresLeDernierTest() {

	}

	@Test
	public void testAddition() {
		assertEquals(5, c.addition(1, 4), 0);
		Assert.assertEquals(10, c.addition(5, 5), 0);
	}

	@Test
	public void testSoustraction() {
		Assert.assertEquals(5, c.soustraction(9, 4), 0);
	}

	@Test
	public void division() throws DivisionParZero {
		Assert.assertEquals(2, c.division(4, 2), 0);
	}

	@Test(expected = DivisionParZero.class)
	public void divisionParZero() throws DivisionParZero {
		c.division(2, 0);
	}
}
