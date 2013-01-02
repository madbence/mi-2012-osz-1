import java.util.*;

/**
 *
 * @author lennon
 */
public interface Algorithm {
	public boolean isFinished();
	public void step();
	public List<Node> getOpenSet();
	public List<Node> getClosedSet();
	public List<Node> getResult();
	public Node getCurrent();
}
