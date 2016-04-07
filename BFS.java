import java.util.*;

public class BFS {

    public Node search(Node initial){

        Queue<Node> frontier = new LinkedList<Node>();
        Set<Node> visited = new HashSet<Node>();

        frontier.add(initial);

        while (!frontier.isEmpty()){
            
            Node current = frontier.remove();
            visited.add(current);
            
            if (current.isGoal()){
                System.out.println("Search Complete! " + visited.size() + " nodes have been visited!");
                return current;
            }

            if (visited.size() % 30000 == 0)
                System.out.println("Searching... Please wait!");

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
