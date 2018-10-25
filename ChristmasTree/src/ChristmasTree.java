import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zach Baklund
 *
 */
public class ChristmasTree {
	
	public class Node
	{
	    private List<Node> children = null;
	    private String value;

	    public Node(String value)
	    {
	        this.children = new ArrayList<>();
	        this.value = value;
	    }

	    public void addChild(Node child)
	    {
	        children.add(child);
	    }
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in); TODO switch input
		Scanner scanner = new Scanner( new File("input.txt"));

		String testCase = scanner.nextLine();
		System.out.println(testCase);
		String treeParams = scanner.nextLine();
		System.out.println(treeParams);
		int n = Integer.parseInt(treeParams.split(" ")[0]);
		int k = Integer.parseInt(treeParams.split(" ")[1]);
		System.out.println(n);
		System.out.println(k);
		
		scanner.close();
	}

}
