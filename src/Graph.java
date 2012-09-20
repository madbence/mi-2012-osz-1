
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

	public int getNodeCount() {
		return nodes.size();
	}

	public int getEdgeCount() {
		return edges.size();
	}

	public int getMinX() {
		if(nodes.isEmpty()) {
			return 0;
		}
		int min = nodes.get(0).getX();
		for(Node n : nodes) {
			min = n.getX() < min ? n.getX() : min;
		}
		return min;
	}

	public int getMinY() {
		if(nodes.isEmpty()) {
			return 0;
		}
		int min = nodes.get(0).getY();
		for(Node n : nodes) {
			min = n.getY() < min ? n.getY() : min;
		}
		return min;
	}

	public int getMaxX() {
		if(nodes.isEmpty()) {
			return 0;
		}
		int max = nodes.get(0).getX();
		for(Node n : nodes) {
			max = n.getX() > max ? n.getX() : max;
		}
		return max;
	}

	public int getMaxY() {
		if(nodes.isEmpty()) {
			return 0;
		}
		int max = nodes.get(0).getY();
		for(Node n : nodes) {
			max = n.getY() > max ? n.getY() : max;
		}
		return max;
	}
}
