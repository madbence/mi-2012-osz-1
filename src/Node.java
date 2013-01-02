
import java.util.*;

/**
 *
 * @author lennon
 */
public class Node {

	private List<Edge> edges;
	private int id;
	private String name;
	private int x;
	private int y;
	private EdgeComparator edgeComparator;

	public Node(int i, String s, int a, int b) {
		id = i;
		name = s;
		x = a;
		y = b;
		edges = new ArrayList<Edge>();
		edgeComparator=new EdgeComparator(this);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Edge e) {
		edges.add(e);
		Collections.sort(edges, edgeComparator);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
