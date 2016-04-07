import java.util.ArrayList;

public class Node {
	
	private int[] puzzle = new int[9];

	private Node parent = null;

	public Node(int[] puzzle){
		for (int i = 0; i < 9; i++){
			this.puzzle[i] = puzzle[i];
		}
	}

	public String toString() {
		String puzzleState = new String();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				puzzleState = puzzleState + " " + puzzle[i * 3 + j];
			}
			puzzleState = puzzleState + "\n";
		}
		return puzzleState;
     }

	public boolean isGoal(){
		for (int i = 0; i < 9; i++){
			if (puzzle[i] != i)
				return false;
		}
		return true;
	}

	private void setParent(Node parent){
		this.parent = parent;
	}

	public Node getParent(){
		return this.parent;
	}

	private int getZeroPosition(){
		for (int i = 0; i < 9; i++){
			if (puzzle[i] == 0)
				return i;
		}
		return -1;
	}

	private int[] getPuzzle()
	{
		int[] ret = new int[9];
		for (int i = 0; i < 9; i++){
			ret[i] = puzzle[i];
		}
		return ret;
	}

	public ArrayList<Node> genSuccessor(){

		ArrayList<Node> successor = new ArrayList<Node>();
		int zero = getZeroPosition();

		if (zero != 0 && zero != 3 && zero != 6){
			swapAndStore(zero - 1, zero, successor);
		}

		if (zero != 6 && zero != 7 && zero != 8){
			swapAndStore(zero + 3, zero, successor);
		}

		if (zero != 0 && zero != 1 && zero != 2){
			swapAndStore(zero - 3, zero, successor);
		}
		
		if (zero != 2 && zero != 5 && zero != 8){
			swapAndStore(zero + 1, zero, successor);
		}
		
		return successor;
	}

	private void swapAndStore(int target, int zeroPosition, ArrayList<Node> successor){
		int[] p = getPuzzle();
		int temp = p[target];
		p[target] = 0;
		p[zeroPosition] = temp;
		Node child = new Node(p);
		child.setParent(this);
		successor.add(child);
	} 
	
	public int misplacedTile(){
		int misplaced = 0;
		for (int i = 0; i < 9; i++){
			if (puzzle[i] != i && puzzle[i] != 0)
				misplaced++;
		}
		return misplaced;
	}
	
	public int manhattan(){
		int distance = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (puzzle[x * 3 + y] != 0){
					distance += Math.abs(puzzle[x * 3 + y] / 3 - x) + Math.abs(puzzle[x * 3 + y] % 3 - y);
				}
			}
		}
		return distance;
	}	

	public int hashCode(){
		int hash = 0;
		for (int i = 0; i < 9; i++){
			hash = hash * 10 + puzzle[i];
		}
		return hash;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node s = (Node) obj;
		
		return (s.puzzle[0] == this.puzzle[0] && s.puzzle[1] == this.puzzle[1] && s.puzzle[2] == this.puzzle[2]	&& s.puzzle[3] == this.puzzle[3] && s.puzzle[4] == this.puzzle[4] && s.puzzle[5] == this.puzzle[5] && s.puzzle[6] == this.puzzle[6] && s.puzzle[7] == this.puzzle[7] && s.puzzle[8] == this.puzzle[8]);
	}
}
