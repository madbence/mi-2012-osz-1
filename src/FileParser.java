
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author lennon
 */
public class FileParser {

	private File file;
	private Graph graph;
	private Node startNode;
	private ArrayList<Node> endNodes;

	private enum Status {

		NODE, EDGE, START, END, HEURISTICS, ALGORITHM
	}

	public FileParser(File f) {
		file = f;
		graph = new Graph();
		endNodes = new ArrayList<Node>();
	}

	public void parse() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		Status status = Status.NODE;
		while((line = br.readLine()) != null) {
			if(line.length() == 0) {
				status = Status.values()[status.ordinal() + 1];
			} else if(!line.startsWith("#")) {

				switch (status) {
					case NODE:
						String[] nodeProps = line.split("\t");
						Node node = new Node(
								Integer.parseInt(nodeProps[0]),
								nodeProps[1],
								Integer.parseInt(nodeProps[2]),
								Integer.parseInt(nodeProps[3]));
						graph.addNode(node);
						break;
					case EDGE:
						String[] edgeProps = line.split("\t");
						Edge edge = new Edge(
								graph.getNode(Integer.parseInt(edgeProps[0])),
								graph.getNode(Integer.parseInt(edgeProps[1])),
								Integer.parseInt(edgeProps[2]));
						graph.addEdge(edge);
						break;
					case START:
						startNode = graph.getNode(Integer.parseInt(line));
						break;
					case END:
						endNodes.add(graph.getNode(Integer.parseInt(line)));
						break;
					case HEURISTICS:
						//
						break;
					case ALGORITHM:
						//
						break;
					default:
						throw new Exception("Unknown FileParser.Status");
				}
			}
		}
	}

	public Graph getGraph() {
		return graph;
	}

	public Node getStartNode() {
		return startNode;
	}

	public ArrayList<Node> getEndNodes() {
		return endNodes;
	}
}
