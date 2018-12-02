import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlates {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		// Scanner scan = new Scanner(new File("input.txt"));

		int plateCount = scan.nextInt();
		
		for (int i = 0; i <= plateCount; i++) {
			String word = scan.nextLine();
			int combos = findCombinations(word);
			System.out.println(combos);
		}

		scan.close();
	}

	private static int findCombinations(String word) {
		int sum = 0;
		for (char first = 'A'; first <= 'Z'; first++) {
			for (char second = 'A'; second <= 'Z'; second++) {
				for (char third = 'A'; third <= 'Z'; third++) {
					String search = Character.toString(first) 
							      + Character.toString(second) 
							      + Character.toString(third);
					
					if(contains(word, search)) {
						sum++;
					}
				}
			}
		}
		return sum;
	}

	static Pattern preparePattern(String searchSequence) {
		StringBuilder pattern = new StringBuilder();
		boolean first = false;
		for (char c : searchSequence.toCharArray()) {
			if (first) {
				first = false;
			} else {
				pattern.append(".*");
			}
			pattern.append(c);
		}
		return Pattern.compile(pattern.toString());
	}

	static boolean contains(String sequence, String searchSequence) {
		Pattern pattern = preparePattern(searchSequence);
		Matcher matcher = pattern.matcher(sequence);
		return matcher.find();
	}
}
