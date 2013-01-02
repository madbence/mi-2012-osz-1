
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lennon
 */
public class ManhattanHeuristics extends ZeroHeuristics {

	public ManhattanHeuristics(Graph g) {
		super(g);
	}

	public double getValue(Node from, List<Node> to) {
		Double min = null;
		for(Node n : to) {
			double dst = Math.abs(from.getX() - n.getX()) + Math.abs(from.getY() - n.getY());
			if(min == null) {
				min = dst;
			} else {
				min = Math.min(min, dst);
			}
		}
		return min;
	}
}
