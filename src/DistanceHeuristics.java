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
	public double getValue(Node from, Node to){
		return (from.getX()-to.getX())*(from.getX()-to.getX())
			+(from.getY()-to.getY())*(from.getY()-to.getY());
	}
}
