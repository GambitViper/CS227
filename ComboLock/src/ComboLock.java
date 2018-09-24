import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class ComboLock {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner( new File("input.txt"));

		String current = scanner.nextLine();
		while(!current.equals("0 0 0 0")) {
			int start = Integer.parseInt(current.split(" ")[0]);
			int first = Integer.parseInt(current.split(" ")[1]);
			int second = Integer.parseInt(current.split(" ")[2]);
			int third = Integer.parseInt(current.split(" ")[3]);
			
			int ticks = 80;
			if(start > first) {
				System.out.println(start + " :s > :f " + first);
				ticks += 40;
				ticks += 40 - (start - first);
			}else {
				ticks += 40 - (first - start);
			}
			ticks += 40;
			if(first > second) {
				System.out.println(first + " :f > :sd " + second);
				ticks += 40;
				ticks += 40 - (first - second);
			}else {
				ticks += 40 - (second - first);
			}
			if(second > third) {
				System.out.println(second + " :sd > :t " + third);
				ticks -= (second - third);
			}else {
				ticks -= (third - second);
			}
			System.out.println("current: " + current + " \n\t ticks: " + ticks + " degrees: " + ticks * 9);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			System.out.println(ticks * 9);
			current = scanner.nextLine();
		}
	}

}
