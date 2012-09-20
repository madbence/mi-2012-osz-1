
import java.util.ArrayList;

/**
 *
 * @author lennon
 */
public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}

	public Node getNode(int id) throws Exception {
		for(Node n : nodes) {
			if(n.getId() == id) {
				return n;
			}
		}
		throw new Exception("Node #" + id + " not found.");
	}
}
