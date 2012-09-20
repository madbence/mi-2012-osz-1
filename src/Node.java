import com.sun.xml.internal.bind.v2.model.core.*;
import java.util.ArrayList;

/**
 *
 * @author lennon
 */
public class Node {

	private ArrayList<Edge> edges;
	private int id;
	private String name;

	public Node(int i, String s) {
		id = i;
		name = s;
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
}
