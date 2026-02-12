
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Dijkstra {
    public static List<String> findShortestPath(Graph graph, String startId, String endId) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> prev = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Node node : graph.nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        Node start = graph.getNode(startId);
        Node end = graph.getNode(endId);

        if (start == null || end == null) return null;

        distances.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Edge edge : current.neighbors) {
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.target)) {
                    distances.put(edge.target, newDist);
                    prev.put(edge.target, current);
                    pq.add(edge.target);
                }
            }
        }

        List<String> path = new ArrayList<>();
        Node current = end;
        while (current != null) {
            path.add(0, current.id);
            current = prev.get(current);
        }
        return path.size() > 1 ? path : null;
    }

    public static List<List<String>> findAllPaths(Graph graph, String startId, String endId) {
        List<List<String>> allPaths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> currentPath = new ArrayList<>();
        dfs(graph, startId, endId, visited, currentPath, allPaths);
        return allPaths;
    }

    private static void dfs(Graph graph, String currentId, String endId, Set<String> visited, List<String> currentPath, List<List<String>> allPaths) {
        visited.add(currentId);
        currentPath.add(currentId);

        if (currentId.equals(endId)) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            Node currentNode = graph.getNode(currentId);
            if (currentNode != null) {
                for (Edge edge : currentNode.neighbors) {
                    if (!visited.contains(edge.target.id)) {
                        dfs(graph, edge.target.id, endId, visited, currentPath, allPaths);
                    }
                }
            }
        }

        visited.remove(currentId);
        currentPath.remove(currentPath.size() - 1);
    }
} 
