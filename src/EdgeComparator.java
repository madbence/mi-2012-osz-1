
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lennon
 */
class EdgeComparator implements Comparator<Edge>{
	private Node startNode;
	public EdgeComparator(Node s){
		startNode=s;
	}
	public int compare(Edge o1, Edge o2) {
		return o1.getEnd(startNode).getId()-o2.getEnd(startNode).getId();
	}
}
