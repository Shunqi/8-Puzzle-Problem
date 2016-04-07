import java.util.*;

public class AStarSearch {

    public Node search(Node initial, int type){

    	Comparator<Node> comparator;
    	if (type == 0){
    		comparator = new NodeComparator0();
    	}
    	else{
    		comparator = new NodeComparator1();
        }
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(100000, comparator);
        Set<Node> visited = new HashSet<Node>();

        frontier.add(initial);

        while (!frontier.isEmpty()){
            
            Node current = frontier.remove();
            visited.add(current);
            
            if (current.isGoal()){
                System.out.println("Search Complete! " + visited.size() + " nodes have been visited!");
            	return current;
            }

            ArrayList<Node> successor = current.genSuccessor();
            
            for (Node test : successor){
                if (!visited.contains(test) && !frontier.contains(test)){
                    frontier.add(test);
                }
            }
        }
        System.out.println("Search Complete! " + visited.size() + " nodes have been visited!");
        return null;
    }

}
