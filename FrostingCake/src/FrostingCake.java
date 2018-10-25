import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class FrostingCake {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		while(scanner.hasNextLine()) {
			int n = Integer.parseInt(scanner.nextLine());
			int[] cols = new int[n];
			int[] rows = new int[n];
			String[] colsStr = scanner.nextLine().split(" ");
			for(int col = 0; col < n; col++) {
				cols[col] = Integer.parseInt(colsStr[col]);
			}
			String[] rowsStr = scanner.nextLine().split(" ");
			for(int row = 0; row < n; row++) {
				rows[row] = Integer.parseInt(rowsStr[row]);
			}
			int[][] painted = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					painted[i][j] = (i + j) % 3;
				}
			}
			int c0 = 0;
			int c1 = 0;
			int c2 = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					switch(painted[i][j]) {
					case 0: c0 += (rows[i] * cols[j]); break;
					case 1: c1 += (rows[i] * cols[j]); break;
					case 2: c2 += (rows[i] * cols[j]);
					}
				}
			}
			System.out.printf("%d %d %d\n", c1, c2, c0);
		}
		scanner.close();
	}

}
