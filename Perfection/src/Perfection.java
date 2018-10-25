import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author Zachary Baklund
 *
 */
public class Perfection {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));

		int curr = scanner.nextInt();
		System.out.println("PERFECTION OUTPUT");
		while(scanner.hasNextInt() && curr != 0) {
			int divSum = divSum(curr);
			String type = perfectionGrade(curr, divSum);
			System.out.printf("%5s  %s\n", curr, type);
			curr = scanner.nextInt();
		}
		System.out.println("END OF OUTPUT");
		
		scanner.close();
	}
	
	private static String perfectionGrade(int curr, int divSum) {
		if(curr == divSum) return "PERFECT";
		else if(curr > divSum) return "DEFICIENT";
		else return "ABUNDANT";
	}

	private static int divSum(int num) { 
        // Final result of summation of divisors 
        int result = 0; 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i)) result += i; 
                else result += (i + num / i); 
            } 
        }
        if (result == 0) return result;
        else return (result + 1); 
    }

}
