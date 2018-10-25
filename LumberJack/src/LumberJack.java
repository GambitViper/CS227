import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class LumberJack {
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		int numLines = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Lumberjacks:");
		for(int i = 0; i < numLines; i++) {
			String line = scanner.nextLine();
			String[] lumberjacks = line.split(" ");			
			System.out.println(isOrdered(lumberjacks) ? "Ordered" : "Unordered");
		}
		
		scanner.close();
	}

	private static boolean isOrdered(String[] lumberjacks) {
		boolean isOrdered = true;
		int check = 0;
		int fbeard = Integer.parseInt(lumberjacks[0]);
		int ebeard = Integer.parseInt(lumberjacks[lumberjacks.length - 1]);
//		System.out.println(fbeard + " -> " + ebeard);
		boolean rtol = (fbeard > ebeard);
//		System.out.println(ltor ? "checking left to right" : "checking right to left");
		if(rtol) {
//			System.out.println(Arrays.toString(lumberjacks));
			List<String> lb = Arrays.asList(lumberjacks); 
			Collections.reverse(lb); 
			lumberjacks = lb.toArray(lumberjacks);
//			System.out.println(Arrays.toString(lumberjacks));
		}
		for(String jack : lumberjacks) {
			int jackLen = Integer.parseInt(jack);
			if(jackLen < check) {
				isOrdered = false;
			}else {
				check = jackLen;
			}
		}
		return isOrdered;
	}
}
