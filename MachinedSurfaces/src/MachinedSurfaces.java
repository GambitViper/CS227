import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class MachinedSurfaces {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));

		int rows = scanner.nextInt();
		while(rows != 0) {
			//Store "image" files in memory
			String[] surface = new String[rows];
			scanner.nextLine();
			for(int i = 0; i < surface.length; i++) {
				surface[i] = scanner.nextLine();
			}
			
			int idx = surface[0].indexOf(' ');
			boolean qcond = true;
			while(idx != -1 && qcond) {
				for(int i = 0; i < surface.length; i++) {
					idx = surface[i].indexOf(' ');
					if(idx == -1) break;
					StringBuilder str = new StringBuilder(surface[i]);
					str.deleteCharAt(idx);
					surface[i] = str.toString();
//					System.out.printf("...Deleting CharAt: %d\n",idx);
				}
//				System.out.printf("Deleted a character of each row\n");
//				System.out.printf("Checking current\n...%s\n", Arrays.toString(surface));
				for(int i = 0; i < surface.length; i++) {
					if(surface[i].indexOf(' ') == -1) qcond = false;
				}
			}
			
//			System.out.println("Completed array");
//			System.out.println(Arrays.toString(surface));
//			System.out.println("~~~~~~~~~~~~~~~");
			
			System.out.println(findDiff(surface));
			
			rows = scanner.nextInt();
		}
		
		scanner.close();
	}

	private static int findDiff(String[] surface) {
		int diff = 0;
		for(int i = 0; i < surface.length; i++) {
			for(int j = 0; j < surface[i].length(); j++) {
				if(surface[i].charAt(j) == ' ') diff++;
			}
		}
		return diff;
	}

}
