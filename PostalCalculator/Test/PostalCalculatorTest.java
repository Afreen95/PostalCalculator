//Mo Kleit 260585368
//Afreen Aliya 260561525

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class PostalCalculatorTest {
	
	//Test that checkWeight() method works properly
	@Test
	public void isCheckWeightValid() {
		//Weights in range
		boolean isValid = PostalCalculator.checkWeight("0.99");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeight(" 1");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeight("10.55 ");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeight("30.0");
		Assert.assertTrue(isValid);
		//Weights out of range
		isValid = PostalCalculator.checkWeight("-1");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight("30.01");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkWeight("45");
		Assert.assertFalse(isValid);	
		//Invalid inputs
		isValid = PostalCalculator.checkWeight("15,0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight("a");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight(" ");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight("!");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight("");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeight("14-45");
		Assert.assertFalse(isValid);
	}
	
	//Test that checkLength() method works properly
	@Test
	public void isCheckLengthValid() {
		//Length in range
		boolean isValid = PostalCalculator.checkLength("10.0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLength(" 145.65");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLength("199.99 ");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLength("200.00");
		Assert.assertTrue(isValid);
		//Length out of range
		isValid = PostalCalculator.checkLength("-0.9");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("6.0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("200.01");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkLength("251");
		Assert.assertFalse(isValid);	
		//Invalid inputs
		isValid = PostalCalculator.checkLength("15,0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("a");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength(" ");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("!");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLength("14-45");
		Assert.assertFalse(isValid);
	}
	
	//Test that checkLength() method works properly
	@Test
	public void isCheckHeightValid() {
		//Height in range
		boolean isValid = PostalCalculator.checkHeight("0.1");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeight(" 2.0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeight("34 ");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeight("200.00");
		Assert.assertTrue(isValid);
		//Height out of range
		isValid = PostalCalculator.checkHeight("-0.9");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("0.099");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("200.01");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkHeight("251");
		Assert.assertFalse(isValid);	
		//Invalid inputs
		isValid = PostalCalculator.checkHeight("15,0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("a");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight(" ");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("!");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeight("14-45");
		Assert.assertFalse(isValid);
	}
	
	//Test that checkWidth() method works properly
	@Test
	public void isCheckWidthValid() {
		//Height in range
		boolean isValid = PostalCalculator.checkWidth("10.0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidth(" 19.55");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidth("136.091 ");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidth("200.00");
		Assert.assertTrue(isValid);
		//Height out of range
		isValid = PostalCalculator.checkWidth("-4");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("4");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("9.9999");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkWidth("200.001");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkWidth("245");
		Assert.assertFalse(isValid);
		//Invalid inputs
		isValid = PostalCalculator.checkWidth("15,0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("a");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth(" ");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("!");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth(".");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidth("14-45");
		Assert.assertFalse(isValid);
	}	
	
	//Test checkPostalType() method
	@Test
	public void checkIsValidPostalType() {
		boolean isValid = PostalCalculator.checkPostalType("R");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkPostalType("r");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkPostalType("X");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkPostalType("x");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkPostalType("P");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkPostalType("p");
		Assert.assertTrue(isValid);		
		isValid = PostalCalculator.checkPostalType("A");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("h");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("-");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType(",");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType(" ");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("45");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("!");
		Assert.assertFalse(isValid);	
		isValid = PostalCalculator.checkPostalType("Priority");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("Xpress");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkPostalType("Regular");
		Assert.assertFalse(isValid);
	}
	
	//Test checkValidPostalCode() method
	@Test
	public void checkIsValidPostalCode() {
		boolean isValid = PostalCalculator.checkValidPostalCode("H2V 1E2");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("t5a 0a1");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("v0e1z0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("V0E1Z0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode(" A0A1A0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("A0A1A0 ");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("H4S0B6");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("L0n1s0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("g0Z1k0");
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkValidPostalCode("111111");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("HHHHH");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("1A01A0");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("AAA1A1");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("A0AB1B");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("D2V1Q2");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("W2V1E2");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("Z2V1E2");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("H2F1E2");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("H2V1I2");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("H2O102");
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkValidPostalCode("H2V1U2");
		Assert.assertFalse(isValid);
	}
	
	//Test calculateRate() method
	@Test
	public void checkCalculateRate() {
		double rate = PostalCalculator.calculateRate(10.0, 10.0, 10.0, 1.0, 'R');
		Assert.assertEquals(5.3, rate, 0.001);
		rate = PostalCalculator.calculateRate(20.0, 20.0, 20.0, 10.0, 'X');
		Assert.assertEquals(14, rate, 0.001);
		rate = PostalCalculator.calculateRate(100.0, 100.0, 100.0, 18.0, 'p');
		Assert.assertEquals(42.4, rate, 0.001);
		rate = PostalCalculator.calculateRate(10, 0.9, 7, 2, 'X');
		Assert.assertEquals(7.3, rate, 0.001);
		rate = PostalCalculator.calculateRate(200, 200, 200, 30, 'R');
		Assert.assertEquals(71, rate, 0.001);	
	}
	
}
