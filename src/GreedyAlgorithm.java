
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lennon
 */
class GreedyAlgorithm extends AStarAlgorithm {

	public GreedyAlgorithm(Node startNode, List<Node> endNodes, Heuristics heuristics) {
		super(startNode, endNodes, heuristics);
	}

	public void step() {
		current = null;
		for(Node n : openSet) {
			if(current == null
					|| heuristics.getValue(n, to) < heuristics.getValue(current, to)
					|| (heuristics.getValue(n, to) == heuristics.getValue(current, to)
					&& n.getId() < current.getId())) {
				current = n;
			}
		}
		if(to.contains(current)) {
			generateResultPath();
			return;
		}
		openSet.remove(current);
		closedSet.add(current);
		for(Edge e : current.getEdges()) {
			Node neighbour = e.getEnd(current);
			if(!closedSet.contains(neighbour)) {
				if(!openSet.contains(neighbour)) {
					openSet.add(neighbour);
					navigation.put(neighbour, current);
				}
			}
		}
	}
}
