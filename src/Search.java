
import java.io.*;

/**
 *
 * @author lennon
 */
public class Search {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			FileParser parser = new FileParser(new File(args[0]));
			BufferedWriter writer=new BufferedWriter(new FileWriter(new File(args[1])));
			parser.parse();
			/*DebugFrame debugFrame = new DebugFrame();
			debugFrame.setGraph(parser.getGraph());
			debugFrame.setStartNode(parser.getStartNode());
			debugFrame.setEndNodes(parser.getEndNodes());
			debugFrame.setVisible(true);
			Heuristics heuristics=parser.getHeuristics();*/
			Algorithm algorithm=parser.getAlgorithm();
			//debugFrame.setAlgorithm(algorithm);
			while(!algorithm.isFinished())
			{
				//Thread.sleep(500);
				algorithm.step();
				//debugFrame.repaint();
			}
			//debugFrame.repaint();
			boolean first=true;
			for(Node n : algorithm.getResult()){
				writer.write((!first?"\n":"")+n.getId());
				first=false;
			}
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
