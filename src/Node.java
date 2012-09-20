
import java.util.ArrayList;

/**
 *
 * @author lennon
 */
public class Node {

	private ArrayList<Edge> edges;
	private int id;
	private String name;
	private int x;
	private int y;

	public Node(int i, String s, int a, int b) {
		id = i;
		name = s;
		x = a;
		y = b;
		edges = new ArrayList<Edge>();
	}

	public void addEdge(Edge e) {
		edges.add(e);
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
