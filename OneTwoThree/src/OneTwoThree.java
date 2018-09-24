import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class OneTwoThree {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		int wordCount = scanner.nextInt();
		for(int i = 0; i < wordCount; i++) {
			String word = scanner.next();
			if(word.length() == 5) {
				System.out.println("3");
			}else {
				word = determine(word);
				System.out.println(word);
			}
		}
		
		scanner.close();
	}

	private static String determine(String word) {
		String[][] oneOrTwo = new String[][] {{"one","1"}, {"two","2"}};
		boolean[] check = new boolean[3];
		for(int i = 0; i < oneOrTwo.length; i++) {
			for(int j = 0; j < word.length(); j++) {
				check[j] = word.charAt(j) == oneOrTwo[i][0].charAt(j);
			}
			if(checkDiff(check)) {
				return oneOrTwo[i][1];
			}
		}
		return "";
	}

	private static boolean checkDiff(boolean[] check) {
		int count = 0;
		for(int i = 0; i < check.length; i++) {
			if(check[i]) count++;
		}
		return count >= 2;
	}

}
