import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class IDS {
    
    private int[] cutoffPuzzle = {9, 9, 9, 9, 9, 9, 9, 9, 9};
    private Node cutoff = new Node(cutoffPuzzle);
    private int nodesVisited = 0;

    public Node search(Node initial){
        int depth = 0;
        while(true){
            Node result = DLS(initial, depth);
            if (result != cutoff){
                System.out.println("Search Complete! " + nodesVisited + " nodes have been visited!");
                return result;
            }
            depth++;
        }
    }


    private Node DLS(Node initial, int limit){

        nodesVisited++;
        
        if (initial.isGoal())    
            return initial;
        else if (limit == 0)    
            return cutoff;
        else{
            boolean cutoff_occurred = false;

            ArrayList<Node> successor = initial.genSuccessor();

            for (Node child : successor){
                if (!isReated(child)){
                    Node result = DLS(child, limit - 1);
                    if (result == cutoff){
                        cutoff_occurred = true;
                    }
                    else if(result != null){
                        return result;
                    }
                }
            }

            if (cutoff_occurred){
                return cutoff;
            }

            else{
                return null;
            }

        }
    }

    private boolean isReated (Node child){
        HashSet<Node> visited = new HashSet<Node>();
        Node test = child;
        while (test.getParent() != null){
            test = test.getParent();
            visited.add(test);
        }

        return visited.contains(child);

    }
}
