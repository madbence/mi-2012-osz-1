
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
public class UniformCostSearchAlgorithm extends AStarAlgorithm{
	public UniformCostSearchAlgorithm(Node f, List<Node> t, Heuristics h){
		super(f, t, new ZeroHeuristics(h.getGraph()));
	}
}
