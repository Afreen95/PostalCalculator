import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PostalCalculatorTest {

	@Test
	public void checkIsMinLength() {
		boolean isValid = PostalCalculator.checkLengthValidity(9.99);
		Assert.assertFalse(isValid);
		isValid = PostalCalculator.checkLengthValidity(10);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(10.1);
		Assert.assertTrue(isValid);
		isValid = PostalCalculator.checkLengthValidity(105);
		Assert.assertTrue(isValid);
		
		
	}

}
