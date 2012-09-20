import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 *
 * @author lennon
 */
public class DebugFrame extends Frame {
	private Graph graph;
	private int borderSize=10;
	public DebugFrame(){
		super();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setResizable(false);
	}
	public void setGraph(Graph g){
		graph=g;
		int width=g.getMaxX()-g.getMinX()+2*borderSize;
		int height=g.getMaxY()-g.getMinY()+2*borderSize;
		setSize(width, height);
	}
	public void paint(Graphics gr)
	{
		Graphics2D g=(Graphics2D)gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for(Node n:graph.getNodes())
		{
			Shape s = new Ellipse2D.Double(n.getX(), n.getY(), 20, 20);
			g.draw(s);
		}
	}

	/**
	 * Fancy double buffering
	 * @param g Native graphics object reference.
	 */
	public void update(Graphics g)
	{
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
