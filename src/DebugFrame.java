
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 *
 * @author lennon
 */
public class DebugFrame extends Frame {

	private Graph graph;
	private double scale = 1.0;
	private double nodeSize = 30;
	private double nodeMargin = 20;
	private int borderSize = 35;
	private Node startNode;
	private ArrayList<Node> endNodes;

	public DebugFrame() {
		super();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//setResizable(false);
	}

	public void setGraph(Graph g) {
		graph = g;
		double width = (g.getMaxX() - g.getMinX()) * (nodeSize + nodeMargin) + 3 * borderSize;
		double height = (g.getMaxY() - g.getMinY()) * (nodeSize + nodeMargin) + 4 * borderSize;
		setSize((int) width, (int) height);
	}

	public void setStartNode(Node n) {
		startNode = n;
	}

	public void setEndNodes(ArrayList<Node> l) {
		endNodes = l;
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for(Edge e : graph.getEdges()) {
			double[] p1 = getNodeCoordinates(e.getEnd1());
			double[] p2 = getNodeCoordinates(e.getEnd2());
			double x1 = p1[0] + nodeSize / 2;
			double y1 = p1[1] + nodeSize / 2;
			double x2 = p2[0] + nodeSize / 2;
			double y2 = p2[1] + nodeSize / 2;
			Shape s = new Line2D.Double(x1, y1, x2, y2);
			g.draw(s);
			g.drawString("" + e.getValue(), (float) ((x1 + x2) / 2), (float) ((y1 + y2) / 2));
		}
		for(Node n : graph.getNodes()) {
			double[] pos = getNodeCoordinates(n);
			Shape s = new Ellipse2D.Double(pos[0], pos[1], 30, 30);
			g.setColor(Color.white);
			g.fill(s);
			g.setColor(Color.black);
			g.draw(s);
			g.drawString(n.getName(), (float) pos[0] + 10, (float) (pos[1] + nodeSize / 2) + 5);
		}
		g.setColor(Color.green);
		double[] start = getNodeCoordinates(startNode);
		Shape s = new Ellipse2D.Double(start[0] - 3, start[1] - 3, 36, 36);
		g.draw(s);
		g.setColor(Color.blue);
		for(Node n : endNodes) {
			double[] pos = getNodeCoordinates(n);
			Shape e = new Ellipse2D.Double(pos[0] - 3, pos[1] - 3, 36, 36);
			g.draw(e);
		}


	}

	public double[] getNodeCoordinates(Node n) {
		double[] a = {
			n.getX() * (nodeSize + nodeMargin) + borderSize,
			n.getY() * (nodeSize + nodeMargin) + borderSize + 30
		};
		return a;
	}

	/**
	 * Fancy double buffering
	 *
	 * @param g Native graphics object reference.
	 */
	public void update(Graphics g) {
		Graphics offgc;
		Image offscreen = null;
		java.awt.Rectangle box = g.getClipRect();

		// buffer
		offscreen = createImage(box.width, box.height);
		offgc = offscreen.getGraphics();
		// delete buffer
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, box.width, box.height);
		offgc.setColor(getForeground());
		// drawing on buffer
		offgc.translate(-box.x, -box.y);
		paint(offgc);
		// copy buffer to screen
		g.drawImage(offscreen, box.x, box.y, this);
	}
}
