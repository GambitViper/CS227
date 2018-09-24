import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class LeapBirthday {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		int testAmt = scanner.nextInt();
		for(int i = 0; i < testAmt; i++) {
			int birthDay = scanner.nextInt();
			int birthMonth = scanner.nextInt();
			int birthYear = scanner.nextInt();
			int queryYear = scanner.nextInt();
			if(birthDay == 29 && birthMonth == 2) {
				int count = 0;
				for(int y = birthYear+1; y <= queryYear; y++) {
					if(isLeapYear(y)) count++;
				}
				System.out.printf("Case %s: %s\n",i+1,count);
			}else {
				System.out.printf("Case %s: %s\n",i+1,queryYear - birthYear);
			}
		}
		scanner.close();
	}
	
	private static boolean isLeapYear(int year) {
		if(year % 400 == 0) return true;
		else if(year % 100 == 0) return false;
		else if(year % 4 == 0) return true;
		else return false;
	}

}
