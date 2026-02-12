import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

class MainFrame extends JFrame {
    private final JTextField startField = new JTextField(5);
    private final JTextField endField = new JTextField(5);
    private final JTextArea resultArea = new JTextArea(15, 40);
    private final Graph graph = Graph.sampleGraph();

    public MainFrame() {
        setTitle("Traffic Navigator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Start:"));
        inputPanel.add(startField);
        inputPanel.add(new JLabel("End:"));
        inputPanel.add(endField);

        JButton findRoute = new JButton("Find Shortest Route");
        findRoute.addActionListener(this::handleFindRoute);
        inputPanel.add(findRoute);

        add(inputPanel, BorderLayout.NORTH);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void handleFindRoute(ActionEvent e) {
        String start = startField.getText().trim();
        String end = endField.getText().trim();

        List<List<String>> allPaths = Dijkstra.findAllPaths(graph, start, end);
        List<String> shortestPath = Dijkstra.findShortestPath(graph, start, end);

        StringBuilder result = new StringBuilder();
        if (allPaths != null && !allPaths.isEmpty()) {
            result.append("All Possible Routes:\n");
            for (List<String> path : allPaths) {
                result.append(String.join(" -> ", path)).append("\n");
            }
            result.append("\nShortest Route:\n");
            result.append(shortestPath != null ? String.join(" -> ", shortestPath) : "No path found");
        } else {
            result.append("No routes found from ").append(start).append(" to ").append(end);
        }
        resultArea.setText(result.toString());
    }
}