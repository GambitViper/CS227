import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class PalindromicPrimes {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in); TODO switch input
		Scanner scanner = new Scanner( new File("input.txt"));
		
		int numPasswords = scanner.nextInt();
		scanner.nextLine();
		for(int i = 0; i < numPasswords; i++) {
			String line = scanner.nextLine();
			int ppm = Integer.parseInt(line);
			boolean check = true;
			StringBuilder str = new StringBuilder();
			int divideBy = 10;
			int k = ppm;
			while(check) {
				k = divideBy % k;
				System.out.println(k);
				divideBy *= 10;
			}
		}
		
		scanner.close();
	}

}
