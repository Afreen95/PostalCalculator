//Mo Kleit 260585368
//Afreen Aliya 260561525

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PostalCalculator {
	
	//Input reader
	public static Scanner sc = new Scanner(System.in);
	
	//User input
	public static String input;
	
	//Postal code validity regex (lower case and upper case)
	public static String regex = "^(?!.*[DFIOQU])[A-VXYa-vxy][0-9][A-Za-z][0-9][A-Za-z][0-9]$";
	public static Pattern pattern = Pattern.compile(regex);
	
	//Variables declaration
	public static double weight, length, height, width;
	public static char postalType;
	public static String postalCode;

	public static void main(String[] args) {
		askWeight();
		askLength();
		askHeight();
		askWidth();
		askPostalType();
		askFromPostalCode();
		askToPostalCode();
		System.out.println("\nRate is : " + calculateRate(length, height, width, weight, postalType) + "$");
	}
	
	//Calculate rate
	public static double calculateRate(double length, double height, double width, double weight, char type) {
		double postalTypeRate;
		double rh = 0.1;	
		if(type == 'r' || type == 'R') {
			postalTypeRate = 2.0;
		}
		else if(type == 'x' || type == 'X') {
			postalTypeRate = 5.0;
		}
		else {
			postalTypeRate = 7.0;
		}
		if (height < 1) {
			rh = 0.0;
		}
		
		return (0.1 * length + 0.1 * width + rh * height + 0.3 * weight + postalTypeRate );
	}
	
	//Verify postal code is okay
	public static boolean checkValidPostalCode(String postal) {
		//Remove all white spaces and invisible character such as tab
		postalCode = postal.replaceAll("\\s", "");
		Matcher matcher = pattern.matcher(postalCode);
		return matcher.matches();
	}
	
	//Verify postal type input is valid
	public static boolean checkPostalType(String input) {
		//Check if input is one character long
		if (input.length() > 1) {
			return false;
		}		
		//Cast string to char
		try {
			postalType = input.charAt(0);
		}
		catch (Exception e) {
			System.out.println("Invalid input!");
			return false;
		}
		if (postalType == 'R' || postalType == 'r' || postalType == 'X' || postalType == 'x' ||
				postalType == 'p' || postalType == 'P') {
			return true;
		}
		return false;
	}
	
	//Check width validity
	public static boolean checkWidth(String input) {
		//Cast input to double
		try {
			width = Double.parseDouble(input);		
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid number format!");
			return false;
		}
		if (width < 10 || width > 200) {
			System.out.println("Width should be between 10cm and 200cm!");
			return false;
		}
		return true;
	}
	
	//Check height validity
	public static boolean checkHeight(String input) {
		//Cast input to double
		try {
			height = Double.parseDouble(input);		
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid number format!");
			return false;
		}
		if (height < 0.1 || height > 200) {
			System.out.println("Height should be between 0.1cm and 200cm!");
			return false;
		}
		return true;
	}
	
	//Check length validity
	public static boolean checkLength(String input) {
		//Cast input to double
		try {
			length = Double.parseDouble(input);		
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid number format!");
			return false;
		}
		if (length < 10 || length > 200) {
			System.out.println("Length should be between 10cm and 200cm!");
			return false;
		}
		return true;
	}
		
	//Check weight validity
	public static boolean checkWeight(String input) {
		//Cast input to double
		try {
			weight = Double.parseDouble(input);		
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid number format!");
			return false;
		}
		if (weight < 0 || weight > 30) {
			System.out.println("Weight should be between 0 and 30kg!");
			return false;
		}
		return true;
	}
	
	//Get input from user
	public static String getInput() {	
		String input = sc.nextLine();
		return input;
	}
	
	// Ask for the postal code they are posting from
	public static void askToPostalCode() {
		System.out.println("Enter the postal code you are posting to: ");
		input = getInput();
		// Check if the format of the provided code is valid.
		if (!checkValidPostalCode(input)) {
			System.out.println("Invalid postal code!");
			askToPostalCode();
		}
	}	
	
	// Ask for the postal code they are posting to
	public static void askFromPostalCode() {
		System.out.println("Enter the postal code you are posting from: ");
		input = getInput();
		// Check if the format of the provided code is valid.
		if (!checkValidPostalCode(input)) {
			askFromPostalCode();
		}
	}
	
	// Ask for postal Type: Regular/Xpress/Priority
	public static void askPostalType() {
		System.out.println("Enter Postal Type. R for Regular. X for Xpress. P for Priority.");
		input = getInput();
		if (!checkPostalType(input)) {
			askPostalType();
		}
	}
	
	//Ask for width of package
	public static void askWidth() {
		System.out.println("Enter a width between 10cm and 200cm: ");
		input = getInput();
		if (!checkWidth(input)) {
			askWidth();
		}
	}
	
	//Ask for height of package
	public static void askHeight() {
		System.out.println("Enter a height between 0.1cm and 200cm: ");
		input = getInput();
		if (!checkHeight(input)) {
			askHeight();
		}
	}
	
	//Ask for length of package
	public static void askLength() {
		System.out.println("Enter a length between 10cm and 200cm: ");
		input = getInput();
		if (!checkLength(input)) {
			askLength();
		}
	}
	
	//Ask for weight of package
	public static void askWeight() {
		System.out.println("Enter a weight (max 30kg) in kg: ");
		input = getInput();
		if (!checkWeight(input)) {
			askWeight();
		}
	}
}
