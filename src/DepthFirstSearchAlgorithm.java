
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class DepthFirstSearchAlgorithm extends AbstractAlgorithm {

	public DepthFirstSearchAlgorithm(Node f, List<Node> t, Heuristics h) {
		super(f, t, h);
		openSet.add(f);
		closedSet.add(f);
	}
	public void step() {
		if(!openSet.isEmpty()){
			current= openSet.get(openSet.size()-1);
			openSet.remove(current);
			if(to.contains(current)){
				generateResultPath();
				return;
			}
			List<Edge> edges=current.getEdges();
			Collections.reverse(edges);
			for(Edge edge : edges){
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
