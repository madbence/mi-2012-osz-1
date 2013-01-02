
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lennon
 */
public abstract class AbstractAlgorithm implements Algorithm {

	protected final Node from;
	protected List<Node> to;
	protected Node current;
	protected List<Node> openSet;
	protected List<Node> closedSet;
	protected List<Node> result;
	protected Map<Node, Node> navigation;
	protected final Heuristics heuristics;
	protected boolean isFinished;

	public AbstractAlgorithm(Node f, List<Node> t, Heuristics h) {
		from = f;
		to = t;
		heuristics = h;
		openSet = new ArrayList<Node>();
		closedSet = new ArrayList<Node>();
		navigation = new HashMap<Node, Node>();
		isFinished = false;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public List<Node> getOpenSet() {
		return openSet;
	}

	public List<Node> getClosedSet() {
		return closedSet;
	}

	public List<Node> getResult() {
		return result;
	}

	public Node getCurrent() {
		return current;
	}
	
	protected void generateResultPath(){
		isFinished = true;
		result = new ArrayList<Node>();
		Node path = current;
		while(navigation.containsKey(path)) {
			result.add(path);
			path = navigation.get(path);
		}
		result.add(from);
		Collections.reverse(result);
		return;
	}
}
