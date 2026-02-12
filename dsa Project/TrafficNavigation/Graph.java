
import java.util.HashMap;
import java.util.Map;

class Graph {
    Map<String, Node> nodes = new HashMap<>();

    public void addEdge(String from, String to, int weight) {
        nodes.putIfAbsent(from, new Node(from));
        nodes.putIfAbsent(to, new Node(to));
        nodes.get(from).neighbors.add(new Edge(nodes.get(to), weight));
    }

    public Node getNode(String id) {
        return nodes.get(id);
    }

public static Graph sampleGraph() {
    Graph g = new Graph();

    // City connections with realistic sample distances (in km)
    g.addEdge("Ludhiana", "Chandigarh", 95);
    g.addEdge("Ludhiana", "Ambala", 130);         // Longer
    g.addEdge("Chandigarh", "Ambala", 45);
    g.addEdge("Chandigarh", "Panipat", 120);
    g.addEdge("Ambala", "Panipat", 90);
    g.addEdge("Panipat", "Delhi", 90);
    g.addEdge("Ambala", "Delhi", 195);            // Direct but longer

    return g;
}


}
