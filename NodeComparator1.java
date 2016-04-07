import java.util.Comparator;

public class NodeComparator1 implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		return n1.manhattan() + depth(n1) - n2.manhattan() - depth(n2);
	}

	public int depth(Node test){
		int depth = 0;
		while( test.getParent() != null ){
			test = test.getParent();
			depth++;
		}
		return depth;
	}
}
