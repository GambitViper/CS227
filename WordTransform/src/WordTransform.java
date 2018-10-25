import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class WordTransform {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner( new File("input.txt"));

		scanner.close();
	}

}
