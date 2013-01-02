
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
public interface Heuristics {

	public double getValue(Node from, List<Node> to);
	public Graph getGraph();
}
