import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author Zach Baklund
 *
 */
public class GroupReverse {
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner( new File("input.txt"));
		while(scanner.hasNext()) {
			int groupSize = scanner.nextInt();
			if(groupSize == 0) break;
//			System.out.println("Grouping: " + groupSize);
			String text = scanner.next();
//			System.out.println("String: " + text);
			String[] grouping = group(groupSize, text);
			String result = reverseCombine(grouping);
			System.out.println(result);
		}
		
		scanner.close();
	}

	/**
	 * 
	 * @param grouping
	 * @return resulting string of reversed groups
	 */
	private static String reverseCombine(String[] grouping) {
		String[] reversedGrouping = new String[grouping.length];
		for(int i = 0; i < grouping.length; i++) {
			String curr = grouping[i];
			reversedGrouping[i] = new StringBuilder(curr).reverse().toString();
		}
//		System.out.println(Arrays.toString(reversedGrouping));
		return String.join("", reversedGrouping);
	}

	/**
	 * 
	 * @param groupSize
	 * @param text
	 * @return grouped sections of text
	 */
	private static String[] group(int groupSize, String text) {
		String[] grouping = new String[text.length() / groupSize];
		int idx = grouping.length - 1;
		int len = text.length();
		while(len != 0) {
			String sub = text.substring(len - groupSize, len);
//			System.out.println(sub);
//			System.out.println("Placing in idx: " + idx);
			grouping[idx] = sub;
			idx--;
			len = len - groupSize;
		}
//		System.out.println(Arrays.toString(grouping));
		return grouping;
	}
}
