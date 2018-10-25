// Java program to check if a given directed graph is strongly 
// connected or not 
import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency 
// list representation 
class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 

	//Constructor 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add an edge into the graph 
	void addEdge(int v,int w) { adj[v].add(w); } 

	// A recursive function to print DFS starting from v 
	void DFSUtil(int v,Boolean visited[]) 
	{ 
		// Mark the current node as visited and print it 
		visited[v] = true; 

		int n; 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].iterator(); 
		while (i.hasNext()) 
		{ 
			n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n,visited); 
		} 
	} 

	// Function that returns transpose of this graph 
	Graph getTranspose() 
	{ 
		Graph g = new Graph(V); 
		for (int v = 0; v < V; v++) 
		{ 
			// Recur for all the vertices adjacent to this vertex 
			Iterator<Integer> i = adj[v].listIterator(); 
			while (i.hasNext()) 
				g.adj[i.next()].add(v); 
		} 
		return g; 
	} 

	// The main function that returns true if graph is strongly 
	// connected 
	Boolean isSC() 
	{ 
		// Step 1: Mark all the vertices as not visited 
		// (For first DFS) 
		Boolean visited[] = new Boolean[V]; 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		// Step 2: Do DFS traversal starting from first vertex. 
		DFSUtil(0, visited); 

		// If DFS traversal doesn't visit all vertices, then 
		// return false. 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				return false; 

		// Step 3: Create a reversed graph 
		Graph gr = getTranspose(); 

		// Step 4: Mark all the vertices as not visited (For 
		// second DFS) 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		// Step 5: Do DFS for reversed graph starting from 
		// first vertex. Staring Vertex must be same starting 
		// point of first DFS 
		gr.DFSUtil(0, visited); 

		// If all vertices are not visited in second DFS, then 
		// return false 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				return false; 

		return true; 
	} 

	public static void main(String args[]) throws FileNotFoundException 
	{ 
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner( new File("input.txt"));
		
		while(scanner.hasNextLine()) {
			String params = scanner.nextLine();
			int numStreets = Integer.parseInt(params.split(" ")[0]);
			int numLines = Integer.parseInt(params.split(" ")[1]);
			if(numLines == 0 && numStreets == 0) {
				break;
			}
			Graph graph = new Graph(numStreets);
			for(int i = 0; i < numLines; ++i) {
				String streetNotation = scanner.nextLine();
				int v = Integer.parseInt(streetNotation.split(" ")[0]);
				int w = Integer.parseInt(streetNotation.split(" ")[1]);
				int p = Integer.parseInt(streetNotation.split(" ")[2]);
				v--;
				w--;
				graph.addEdge(v, w);
				if(p == 2) {
					graph.addEdge(w, v);
				}
			}
			if (graph.isSC()) System.out.println("1"); 
			else System.out.println("0");
		}

		scanner.close(); 
	} 
}
