
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
public class ZeroHeuristics implements Heuristics {

	protected Graph graph;

	public ZeroHeuristics(Graph g) {
		graph = g;
	}

	public double getValue(Node from, List<Node> to) {
		return 0;
	}
	public Graph getGraph() {
		return graph;
	}
}
