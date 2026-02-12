
import java.util.ArrayList;
import java.util.List;

class Node {
    String id;
    List<Edge> neighbors = new ArrayList<>();

    public Node(String id) {
        this.id = id;
    }
}