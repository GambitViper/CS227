import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;
/**
 * 
 * @author Zach Baklund
 *
 */
public class AutoAnswer {
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		int numCases = scanner.nextInt();
		
		for(int i = 0; i < numCases; i++) {
			BigInteger num = scanner.nextBigInteger();
			BigInteger calc = calculate(num);
//			System.out.printf("Calculated: %s \n", calc.toString());
			int digit = findDigit(calc);
			System.out.println(digit);
		}
		
		scanner.close();
	}
	
	private static BigInteger calculate(BigInteger val) {
//		System.out.printf("Pre-Calculation %s \n", val.toString());
		val = val.multiply(new BigInteger("567"));
//		System.out.printf("Calculating * 567 %s \n", val.toString());
		val = val.divide(new BigInteger("9"));
//		System.out.printf("Calculating / 9 %s \n", val.toString());
		val = val.add(new BigInteger("7492"));
//		System.out.printf("Calculating + 7492 %s \n", val.toString());
		val = val.multiply(new BigInteger("235"));
//		System.out.printf("Calculating * 235 %s \n", val.toString());
		val = val.divide(new BigInteger("47"));
//		System.out.printf("Calculating / 47 %s \n", val.toString());
		val = val.subtract(new BigInteger("498"));
//		System.out.printf("Calculating - 498 %s \n", val.toString());
		return val;
	}

	/**
	 * Takes the current answer and finds the digit
	 * @param val
	 * @return the digit in the tens column
	 */
	private static int findDigit(BigInteger val) {
//		System.out.println("Calculated Digit num: " + val);
		if(val.toString().contains("-")) {
			val = val.negate();
		}
		val = val.mod(new BigInteger("100"));
//		System.out.println("Calculated Digit num: " + val);
		val = val.divide(new BigInteger("10"));
//		System.out.println("Calculated Digit num: " + val);
		return val.intValue();
	}
}
