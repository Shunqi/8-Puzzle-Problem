import java.util.Scanner;

public class EightPuzzle {

	public static void main(String[] args) {
		int initial[] = {7, 2, 4, 5, 0, 6, 8, 3, 1};		
		Node initialNode = new Node(initial);
		System.out.println("Welcome to the EightPuzzle Problem Solver!\nHere's the instructions:");
		System.out.println("1. Breadth First Search");
		System.out.println("2. Interative Deepening Search");
		System.out.println("3. A* search using number of misplaced tiles");
		System.out.println("4. A* search using sum of Manhattan distances");
		System.out.println("5. Exit");
		Scanner in = new Scanner(System.in); 

		while (true){
			System.out.print("Enter the number: ");
			int option = in.nextInt();
			switch(option){
				case 1: breadthFirstSearch(initialNode);
						break;
				case 2: iterativeDeepening(initialNode);
						break;
				case 3: aStar(initialNode, 0);
						break;
				case 4: aStar(initialNode, 1);
						break;
				case 5: System.out.print("Byebye!");
						System.exit(0);
						break;
				default: System.out.println("Incorrect enter! Please enter again!");
						break;
			}
		}
		
	}

	//print the path and the number of moves from the root to the specific node
	private static void printpath(Node pathNode){
		int move = -1;
	 	if (pathNode == null) System.out.println("No Solution!");
	 	else {
	 		String path = new String();
	 		while (pathNode != null){
	 			path = pathNode.toString() + "\n" + path;	 			
	 			pathNode = pathNode.getParent();
	 			move++;
	 		}
	 		System.out.print(path);
	 		System.out.println("Number of moves in this path: " + move);
	 	}
	 }

	 private static void breadthFirstSearch(Node initialNode){
		BFS bfs = new BFS(); 
		System.out.println("Uninformed breadth-first search: ");
	 	long startTime = System.currentTimeMillis();	
		Node pathNode = bfs.search(initialNode);
		long endTime = System.currentTimeMillis();
		printpath(pathNode);
		System.out.println("Time used: " + (endTime - startTime) + "ms.");
	 } 

	 private static void iterativeDeepening(Node initialNode){
		IDS ids = new IDS(); 
	    System.out.println("Iterative Deepening search: ");
	 	long startTime = System.currentTimeMillis();	
		Node pathNode = ids.search(initialNode);
		long endTime = System.currentTimeMillis();
		printpath(pathNode);
		System.out.println("Time used: " + (endTime - startTime) + "ms.");
	 } 

	 //use a integer type to verify which heuristic function to use
	 private static void aStar(Node initialNode, int type){
		AStarSearch astar = new AStarSearch(); 
		if (type == 0)
			System.out.println("A* search using number of misplaced tiles: ");
		else 
			System.out.println("A* search using sum of Manhattan distances");
	 	long startTime = System.currentTimeMillis();	
		Node pathNode = astar.search(initialNode, type);
		long endTime = System.currentTimeMillis();
		printpath(pathNode);
		System.out.println("Time used: " + (endTime - startTime) + "ms.");
	 } 
}
