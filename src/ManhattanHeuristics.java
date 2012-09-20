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

	public double getValue(Node from, Node to) {
		return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
	}
}
