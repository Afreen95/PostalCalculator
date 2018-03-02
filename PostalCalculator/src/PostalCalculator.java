import java.util.*;

public class PostalCalculator {
	// float length, width, height, weight;

	public static double length, width, height, weight;
	public static String toPostalCode, fromPostalCode;
	public static char postalType;
	// One postal code from each province and territory in Canada in Alphabetically
	// order
	public static String[] validPostalCodes = { "t5a0a1", "v0e1z0", "r2c0a1", "e3a0a1", "a0a1j0", "b3h4r2", "k9j0e7",
			"c1a0a1", "h2x1s8", "s0k4s0", "x0e0y0", "x0a0h0", "y1a0a1" };

	public static Scanner sc = new Scanner(System.in);

	
	// TODO: Check if the Postal Code exists in the array provided
	
	public static void main(String[] args) {
		System.out.println("Postal Calculator");
		askLength();
		askHeight();
		askWidth();
		checkGirth();
		askPostalType();
		askToPostalCode();
		askFromPostalCode();
		System.out.println(calculateRate());
	}

	// Keeps asking for the length till we get a valid length
	public static void askLength() {
		System.out.println("Enter Valid Length in cm: ");
		length = sc.nextLong();
		if (!checkLengthValidity(length)) {
			askLength();
		}

	}

	// Checking if length is valid
	public static boolean checkLengthValidity(double length) {
		if (length < 10 || length > 200) {
			return false;
		}
		return true;
	}

	// Keeps asking for the width till we get a valid length
	public static void askWidth() {
		System.out.println("Enter Valid Width in cm:");
		width = sc.nextLong();
		if (!checkLengthValidity(width)) {
			askWidth();
		}

	}

	// Checking if width is valid
	public static boolean checkWidthValidity(double width) {
		if (width < 7 || width > 200) {
			return false;
		}
		return true;
	}

	// Keeps asking for the height till we get a valid height
	public static void askHeight() {
		System.out.println("Enter Valid Height in cm: ");
		height = sc.nextLong();
		if (!checkLengthValidity(height)) {
			askHeight();
		}

	}

	// Checking if height is valid
	public static boolean checkHeightValidity(double height) {
		if (height < 0.1 || height > 200) {
			return false;
		}
		return true;
	}

	// Keeps asking for the height till we get a valid height
	public static void askWeight() {
		System.out.println("Enter Valid Weight in kg: ");
		weight = sc.nextLong();
		if (!checkLengthValidity(weight)) {
			askHeight();
		}

	}

	// Checking if height is valid
	public static boolean checkWeightValidity(double weight) {
		if (weight < 0 || weight > 30) {
			return false;
		}
		return true;
	}

	// Check if Girth is Valid
	public static void checkGirth() {
		if ((height + width) * 2 > 300) {
			System.out.println("The girth should be less than 300 cm.");
			askHeight();
			askWidth();
			checkGirth();
		}
	}

	// Ask for postal Type: Regular/Xpress/Priority
	public static void askPostalType() {
		System.out.println("Enter Postal Type. R for Regular. X for Xpress. P for Priority.");
		postalType = sc.next().charAt(0);
		if (!(postalType == 'R' || postalType == 'r' || postalType == 'X' || postalType == 'x' || postalType == 'p'
				|| postalType == 'P')) {
			askPostalType();
		}
	}

	// Ask for the postal code they are posting from
	public static void askToPostalCode() {
		sc.nextLine();
		System.out.println("Enter the postal code you are posting from: ");
		toPostalCode = sc.nextLine();
		// Removing all spaces from the string provided to make computations easier.
		toPostalCode = toPostalCode.replaceAll(" ", "");
		// If length not 6, ask for postal code again
		if (toPostalCode.length() != 6) {
			askToPostalCode();
		}
		// Check if the format of the provided code is valid.
		if (!checkValidPostalCodeFormat(toPostalCode)) {
			askToPostalCode();
		}
		/*
		if (validPostalCode(toPostalCode)) {
			askFromPostalCode();
		}
		*/
	}

	// Ask for the postal code they are posting to
	public static void askFromPostalCode() {
		System.out.println("Enter the postal code you are posting to: ");
		fromPostalCode = sc.nextLine();
		// Removing all spaces from the string provided to make computations easier.
		fromPostalCode = fromPostalCode.replaceAll(" ", "");
		// If length not 6, ask for postal code again
		if (fromPostalCode.length() != 6) {
			System.out.println("Invalid postal Code length");
			askFromPostalCode();
		}
		// Check if the format of the provided code is valid.
		if (!checkValidPostalCodeFormat(fromPostalCode)) {
			System.out.println("Invalid postal Code format");
			askFromPostalCode();
		}
		
		/*
		if (validPostalCode(fromPostalCode)) {
			System.out.println("Invalid postal Code. Not in provided array");
			askFromPostalCode();
		}
		*/
	}
	
	/*
	public static boolean validPostalCode(String postalCode) {
		for(String s: validPostalCodes){
	        if(s.equals(postalCode)) {
	        	return true;
	        }
	    }
    	return false;
	}
	*/

	// Checking if the format of the provided is correct
	// 1st, 3rd, 5th char have to be letters and others have to be digits
	public static boolean checkValidPostalCodeFormat(String postalCode) {
		if (!Character.isDigit(postalCode.charAt(1)) || !Character.isDigit(postalCode.charAt(3))
				|| !Character.isDigit(postalCode.charAt(5))) {
			System.out.println("Number Problem");
			return false;
		}
		if (!Character.isLetter(postalCode.charAt(0)) || !Character.isLetter(postalCode.charAt(2))
				|| !Character.isLetter(postalCode.charAt(4))) {
			System.out.println("Letter Problem");
			return false;
		}
		return true;
	}
	
	public static double calculateRate() {
		double postalTypeRate;
		if(postalType == 'r' || postalType == 'R') {
			postalTypeRate = 2.0;
		}
		else if(postalType == 'x' || postalType == 'X') {
			postalTypeRate = 5.0;
		}
		else {
			postalTypeRate = 7.0;
		}
		return (0.1 * length + 0.1 * width + 0.1 * height + 0.3 * weight + 0.4 * postalTypeRate );
	}

}
