import java.util.*;


public class PostalCalculator {
	//float length, width, height, weight;
	public PostalType type;
	
	
	public enum PostalType{
		Regular, Xpress, Priority;
	}
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Postal Calculator");
		askLength();
	}
	
	// Keeps asking for the length till we get a valid length
	public static void askLength() {
		System.out.println("Enter Valid Length in cm: ");
	    double length = sc.nextLong(); 
	    if(!checkLengthValidity(length)) {
	    	askLength();
	    }
		
	}
	
	// Checking if length is valid
	public static boolean checkLengthValidity(double length) {
	    if(length < 10) {
	    	return false;
	    }
	    return true;
	}
	
}
