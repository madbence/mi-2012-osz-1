
/**
 *
 * @author lennon
 */
class Edge {

	private Node end1;
	private Node end2;
	private int value;

	public Edge(Node e1, Node e2, int v) {
		end1 = e1;
		end2 = e2;
		value = v;
		e1.addEdge(this);
		e2.addEdge(this);
	}

	public Node getEnd1() {
		return end1;
	}

	public Node getEnd2() {
		return end2;
	}

	public int getValue() {
		return value;
	}

	public Node getEnd(Node n) {
		if(n == end1) {
			return end2;
		}
		return end1;
	}
}
