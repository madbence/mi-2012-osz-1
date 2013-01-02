
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
class BreadthFirstSearchAlgorithm extends AStarAlgorithm {

	public BreadthFirstSearchAlgorithm(Node f, List<Node> t, Heuristics h) {
		super(f, t, h);
		openSet.add(f);
		closedSet.add(f);
	}
	
	public void step() {
		if(!openSet.isEmpty()){
			current= openSet.get(0);
			openSet.remove(current);
			if(to.contains(current)){
				generateResultPath();
				return;
			}
			for(Edge edge : current.getEdges()){
				Node neighbour=edge.getEnd(current);
				if(!closedSet.contains(neighbour)){
					closedSet.add(neighbour);
					openSet.add(neighbour);
					navigation.put(neighbour, current);
				}
			}
		}
	}
}
