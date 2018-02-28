import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PostalCalculatorTest {

	@Test
	public void checkIsValidLength() {
		boolean isValid = PostalCalculator.checkLengthValidity(9.99);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLengthValidity(10);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(10.1);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(105);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(205);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLengthValidity(200);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(200.01);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLengthValidity(55);
		Assert.assertTrue(isValid);
	}
	
	
	@Test
	public void checkIsValidWidth() {
		boolean isValid = PostalCalculator.checkWidthValidity(7);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidthValidity(6.99);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidthValidity(7.01);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidthValidity(105);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidthValidity(205);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidthValidity(200);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWidthValidity(200.01);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWidthValidity(55);
		Assert.assertTrue(isValid);
	
	}

	@Test
	public void checkIsValidHeight() {
		boolean isValid = PostalCalculator.checkHeightValidity(0.09);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeightValidity(0.1);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeightValidity(2);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeightValidity(0.5);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeightValidity(205);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeightValidity(200);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkHeightValidity(200.01);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkHeightValidity(55);
		Assert.assertTrue(isValid);
	
	}
	
	@Test
	public void checkIsValidWeight() {
		boolean isValid = PostalCalculator.checkWeightValidity(0.09);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeightValidity(0.1);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeightValidity(2);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeightValidity(0.5);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeightValidity(31);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeightValidity(30);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkWeightValidity(-2);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkWeightValidity(15);
		Assert.assertTrue(isValid);
	
	}
}
