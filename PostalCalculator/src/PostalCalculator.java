import java.util.*;

public class PostalCalculator {
	// float length, width, height, weight;
	public PostalType type;
	public static double length, width, height, weight;
	private static String toPostalCode, fromPostalCode;
	private static char postalType;

	public enum PostalType {
		Regular, Xpress, Priority;
	}

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Postal Calculator");
		askLength();
		askHeight();
		askWidth();
		checkGirth();

	}

	// TODO: Girth check?

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
	public static void checkGirth() {
		if((height+width) * 2 > 300) {
			System.out.println("The girth should be less than 300 cm.");
			askHeight();
			askWidth();
			checkGirth();
		}
	}

	public static boolean checkIsNumberFormat() {
		// TODO: Check format of number
		return true;
	}

}
