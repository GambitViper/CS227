import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class ShatteredCake {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		while(scanner.hasNext()) {
			int width = Integer.parseInt(scanner.nextLine());
			int pieces = Integer.parseInt(scanner.nextLine());
			int totalArea = 0;
			for(int i = 0; i < pieces; i++) {
				String[] line = scanner.nextLine().split(" ");
				int area = Integer.parseInt(line[0]) * Integer.parseInt(line[1]);
				totalArea += area;
			}
			System.out.println(totalArea / width);
		}
		
		scanner.close();
	}

}
