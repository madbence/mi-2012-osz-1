
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
public class DistanceHeuristics extends ZeroHeuristics{
	public DistanceHeuristics(Graph g){
		super(g);
	}
	public double getValue(Node from, List<Node> to){
		Double min = null;
		for(Node n : to) {
			double dst = (from.getX()-n.getX())*(from.getX()-n.getX())
			+(from.getY()-n.getY())*(from.getY()-n.getY());
			dst=Math.sqrt(dst);
			if(min == null) {
				min = dst;
			} else {
				min = Math.min(min, dst);
			}
		}
		return min;
	}
}
