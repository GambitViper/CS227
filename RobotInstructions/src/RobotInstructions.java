import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class RobotInstructions {
	
	public enum Instruction {
		LEFT, RIGHT, SAME_AS
	}
	
	private static Instruction getType(String check) {
		if(check.equals("LEFT")) {
			return Instruction.LEFT;
		}else if(check.equals("RIGHT")) {
			return Instruction.RIGHT;
		}else {
			return Instruction.SAME_AS;
		}
	}
	
	private static int parseSameAs(String str) {
		int idx = Integer.parseInt(str.split(" ")[2]);
//		System.out.printf("Indexed same as: %d", idx-1);
		return idx-1;
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));

		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int structCt = scanner.nextInt();
			scanner.nextLine();
//			System.out.printf("Instruction count: %d\n", structCt);
			int pos = 0;
			ArrayList<String> instructions = new ArrayList<String>();
			for(int j = 0; j < structCt; j++) {
				String in = scanner.nextLine();
				instructions.add(in);
				if(getType(in) == Instruction.LEFT) {
					pos--;
				}else if(getType(in) == Instruction.RIGHT) {
					pos++;
				}else {
					while(getType(in) == Instruction.SAME_AS) {
						int idx = parseSameAs(in);
						in = instructions.get(idx);
					}
//					System.out.printf("Parse as: %s", in);
					if(getType(in) == Instruction.LEFT) {
						pos--;
					}else if(getType(in) == Instruction.RIGHT) {
						pos++;
					}
				}
//				System.out.printf("Id: %d, Instruction %s\n", j + 1, in);
			}
			System.out.println(pos);
		}
		
		scanner.close();
	}

}
