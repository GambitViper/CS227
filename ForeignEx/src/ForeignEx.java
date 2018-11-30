import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class ForeignEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		while(n != 0) {
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
			for(int i = 0; i < n; i++) {
				int src = scnr.nextInt();
				int dest = scnr.nextInt();
				if(hmap.containsKey(src)) {
					int newval = hmap.get(src).intValue() + 1;
					hmap.put(src, newval);
				}else {
					hmap.put(src, 1);
				}
				if(hmap.containsKey(dest)) {
					int newval = hmap.get(dest).intValue() + 1;
					hmap.put(dest, newval);
				}else {
					hmap.put(dest, 1);
				}
			}
			boolean foundOdd = false;
			for (Integer value : hmap.values()) {
				if(value.intValue() % 2 != 0) foundOdd = true;
			}
			if(foundOdd) System.out.println("NO");
	        if(!foundOdd) System.out.println("YES");
			n = scnr.nextInt();
		}
		scnr.close();
	}

}
