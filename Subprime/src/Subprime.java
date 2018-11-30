import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Zachary Baklund
 *
 */
public class Subprime {

	public class Transaction {
		public int debtor;
		public int creditor;
		public int value;

		public Transaction(int d, int c, int v) {
			this.debtor = d;
			this.creditor = c;
			this.value = v;
		}

		public String toString() {
			return "(" + this.debtor + " -> " + this.creditor + " : " + this.value + ")";
		}
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Subprime finder = new Subprime();
		finder.determine();
	}

	public void determine() throws FileNotFoundException {
		 Scanner scan = new Scanner(System.in);
//		Scanner scan = new Scanner(new File("input.txt"));

		int banks = scan.nextInt();
		int debents = scan.nextInt();
		while (banks != 0 && debents != 0) {
			int[] reserves = new int[banks];
			for (int i = 0; i < banks; i++) {
				reserves[i] = scan.nextInt();
			}
			ArrayList<Transaction> transactions = new ArrayList<>();
			for (int i = 0; i < debents; i++) {
				int debtor = scan.nextInt();
				int creditor = scan.nextInt();
				int value = scan.nextInt();
				transactions.add(new Transaction(debtor - 1, creditor - 1, value));
			}
			boolean usedBreak = false;
			while (!transactions.isEmpty()) {
				Transaction curr = transactions.get(0);
				if (reserves[curr.debtor] >= curr.value) {
					reserves[curr.debtor] -= curr.value;
					reserves[curr.creditor] += curr.value;
					transactions.remove(0);
				} else {
					int amtable = reserves[curr.debtor];
					int stillowed = curr.value - amtable;
					reserves[curr.debtor] -= amtable;
					reserves[curr.creditor] += amtable;
					boolean hasDebtor = hasDebtor(curr.debtor, transactions, reserves);
					if(!hasDebtor) {
						usedBreak = true;
						break;
					}
					transactions.remove(0);
					transactions.add(new Transaction(curr.debtor, curr.creditor, stillowed));
				}
			}
			if(usedBreak) {
				System.out.println("N");
			}else {
				System.out.println("S");
			}
			banks = scan.nextInt();
			debents = scan.nextInt();
		}

		scan.close();
	}

	private boolean hasDebtor(int debtor, ArrayList<Transaction> trans, int[] reserves) {
		for(Transaction t : trans) {
			if(t.creditor == debtor) {
				return true;
			}
		}
		return false;
	}

}
