import java.util.Comparator;

public class NodeComparator0 implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		return n1.misplacedTile() + depth(n1) - n2.misplacedTile() - depth(n2);
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
