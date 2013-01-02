
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lennon
 */
public class AStarAlgorithm extends AbstractAlgorithm {

	protected Map<Node, Double> cost;
	protected Map<Node, Double> estimatedCost;

	public AStarAlgorithm(Node f, List<Node> t, Heuristics h) {
		super(f, t, h);
		openSet.add(f);
		cost = new HashMap<Node, Double>();
		estimatedCost = new HashMap<Node, Double>();
		cost.put(f, (double) 0);
		estimatedCost.put(f, h.getValue(f, t));
	}

	public void step() {
		current = null;
		for(Node n : openSet) {
			if(current == null || estimatedCost.get(n) < estimatedCost.get(current)) {
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
				double costSoFar = cost.get(current) + e.getValue();
				if(!openSet.contains(neighbour) || (cost.containsKey(neighbour) && cost.get(neighbour) > costSoFar)) {
					if(!openSet.contains(neighbour)) {
						openSet.add(neighbour);
					}
					navigation.put(neighbour, current);
					cost.put(neighbour, costSoFar);
					estimatedCost.put(neighbour, costSoFar + heuristics.getValue(neighbour, to));
				}
			}
		}
	}
}
