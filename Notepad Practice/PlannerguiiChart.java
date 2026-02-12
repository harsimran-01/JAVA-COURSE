import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

class Expense {
    String category;
    int amount;
    LocalDate date;

    public Expense(String category, int amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return category + " - ₹" + amount + " on " + date;
    }
}

public class PlannerguiiChart extends JFrame {
    int totalIncome = 0;
    private int savingsGoal = 0;
    HashMap<String, Integer> budgetMap = new HashMap<>();
    ArrayList<Expense> expenses = new ArrayList<>();

    JTextArea reportArea = new JTextArea(18, 50);
    JPanel buttonPanel = new JPanel(new GridLayout(2, 5, 15, 15));

    public PlannerguiiChart() {
        setTitle("📘 Offline Budget Planner");
        setSize(1100, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));
        getContentPane().setBackground(new Color(240, 248, 255));

        JLabel header = new JLabel("📘 Offline Budget Planner", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        reportArea.setEditable(false);
        reportArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        reportArea.setBackground(new Color(255, 255, 245));
        reportArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        buttonPanel.setBackground(new Color(220, 235, 250));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(135, 206, 235)),
                        "Options",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        String[] buttonNames = {
                "Add Monthly Budget", "Add Expense", "View Report",
                "Export Report", "View Pie Chart",
                "Update Expense", "Delete Expense", "Category Summary", "Monthly Trend"
        };

        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(200, 225, 255));
            btn.setForeground(Color.DARK_GRAY);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(100, 149, 237), 1, true),
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)));

            btn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(180, 210, 255));
                }
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(200, 225, 255));
                }
            });

            btn.addActionListener(this::handleButton);
            buttonPanel.add(btn);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.SOUTH);
    }

    private void handleButton(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getText();
        switch (cmd) {
            case "Add Monthly Budget" -> showAddBudgetDialog();
            case "Add Expense" -> showAddExpenseDialog();
            case "View Report" -> viewReport();
            case "Export Report" -> exportReport();
            case "View Pie Chart" -> showPieChart();
            case "Update Expense" -> updateExpense();
            case "Delete Expense" -> deleteExpense();
            case "Category Summary" -> showCategorySummary();
            case "Monthly Trend" -> showMonthlyTrend();
        }
    }

    // ... rest of the methods go here ...

    void showAddBudgetDialog() {
        JTextField incomeField = new JTextField();
        String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Miscellaneous", "Savings"};
        JPanel panel = new JPanel(new GridLayout(categories.length + 1, 2, 10, 10));
        panel.setPreferredSize(new Dimension(350, 250));

        panel.add(new JLabel("Total Income:"));
        panel.add(incomeField);

        Map<String, JTextField> fields = new LinkedHashMap<>();
        for (String category : categories) {
            JTextField field = new JTextField();
            fields.put(category.toLowerCase(), field);
            panel.add(new JLabel(category + ":"));
            panel.add(field);
        }

        // Enable Enter key to move to next field
        for (JTextField field : fields.values()) {
            field.addActionListener(e -> {
                field.transferFocus();
            });
        }
        incomeField.addActionListener(e -> incomeField.transferFocus());

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        wrapper.add(panel, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(null, wrapper, "Add Monthly Budget", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                totalIncome = Integer.parseInt(incomeField.getText());
                for (String cat : fields.keySet()) {
                    int val = Integer.parseInt(fields.get(cat).getText());
                    budgetMap.put(cat, val);
                }
                savingsGoal = budgetMap.getOrDefault("savings", 0);
                JOptionPane.showMessageDialog(this, "✅ Budget added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Invalid input. Use numbers only.");
            }
        }
    }

    void showAddExpenseDialog() {
        String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Miscellaneous", "Savings"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);
        JTextField amountField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Category:"));
        panel.add(categoryBox);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        wrapper.add(panel, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, wrapper, "Add Expense", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String category = ((String) categoryBox.getSelectedItem()).toLowerCase();
                int amount = Integer.parseInt(amountField.getText());
                expenses.add(new Expense(category, amount, LocalDate.now()));
                JOptionPane.showMessageDialog(this, "✅ Expense added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Invalid input. Use valid values.");
            }
        }
    }

void showPieChart() {
    JFrame frame = new JFrame("📊 Expense Pie Chart");
    frame.setSize(900, 650);
    frame.setLocationRelativeTo(this);

    JPanel panel = new JPanel() {
        javax.swing.Timer animationTimer;
        int animatedAngle = 0;

        {
            animationTimer = new javax.swing.Timer(10, e -> {
                animatedAngle += 5;
                if (animatedAngle >= 360) {
                    animatedAngle = 360;
                    animationTimer.stop();
                }
                repaint();
            });
            animationTimer.start();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            setBackground(new Color(250, 252, 255));

            int total = expenses.stream().mapToInt(e -> e.amount).sum();
            if (total == 0) {
                g2.setColor(Color.GRAY);
                g2.setFont(new Font("Segoe UI", Font.BOLD, 18));
                g2.drawString("No expense data to display.", getWidth() / 2 - 140, getHeight() / 2);
                return;
            }

            Map<String, Integer> categoryTotals = new LinkedHashMap<>();
            for (Expense e : expenses) {
                categoryTotals.put(e.category, categoryTotals.getOrDefault(e.category, 0) + e.amount);
            }

            int pieSize = 350;
            int pieX = (getWidth() - pieSize) / 2;
            int pieY = (getHeight() - pieSize) / 2;
            int centerX = pieX + pieSize / 2;
            int centerY = pieY + pieSize / 2;
            int startAngle = 0;
            int i = 0;

            Color[] colors = {
                new Color(255, 179, 186),
                new Color(255, 223, 186),
                new Color(255, 255, 186),
                new Color(186, 255, 201),
                new Color(186, 225, 255),
                new Color(218, 186, 255),
                new Color(200, 200, 255)
            };

            // Title Text - Moved Higher and Centered
            g2.setFont(new Font("Segoe UI", Font.BOLD, 24));
            g2.setColor(new Color(30, 30, 30));
            String title = "Expense Distribution";
            FontMetrics titleMetrics = g2.getFontMetrics();
            int titleX = (getWidth() - titleMetrics.stringWidth(title)) / 2;
            g2.drawString(title, titleX, pieY - 60);

            Set<Integer> usedY = new HashSet<>();

            for (Map.Entry<String, Integer> entry : categoryTotals.entrySet()) {
                int value = entry.getValue();
                double percent = value * 100.0 / total;
                int angle = (int) Math.round((value / (double) total) * 360);

                if (angle < 3) continue;
                if (startAngle >= animatedAngle) break;
                if (startAngle + angle > animatedAngle) {
                    angle = animatedAngle - startAngle;
                }

                Color color = colors[i % colors.length];
                g2.setColor(color);
                g2.fillArc(pieX, pieY, pieSize, pieSize, startAngle, angle);

                // Slice Border - Thicker and More Distinct
                g2.setStroke(new BasicStroke(2f));
                g2.setColor(Color.DARK_GRAY);
                g2.drawArc(pieX, pieY, pieSize, pieSize, startAngle, angle);

                // Label line & text positioning
                double midAngle = Math.toRadians(startAngle + angle / 2.0);
                int radius = pieSize / 2 - 30;
                int outerRadius = radius + 70;

                int labelX = (int) (centerX + Math.cos(midAngle) * radius);
                int labelY = (int) (centerY - Math.sin(midAngle) * radius);
                int outerX = (int) (centerX + Math.cos(midAngle) * outerRadius);
                int outerY = (int) (centerY - Math.sin(midAngle) * outerRadius);

                while (usedY.contains(outerY)) outerY += 12;
                usedY.add(outerY);

                g2.setColor(Color.BLACK);
                g2.drawLine(labelX, labelY, outerX, outerY);
                drawMultilineLabel(g2, capitalize(entry.getKey()), value, percent, outerX + 10, outerY - 10);
                startAngle += angle;
                i++;
            }

            // Outer Pie Border
            g2.setColor(new Color(100, 100, 100, 80));
            g2.setStroke(new BasicStroke(2f));
            g2.drawOval(pieX, pieY, pieSize, pieSize);
        }

        void drawMultilineLabel(Graphics2D g2, String name, int amount, double percent, int x, int y) {
            FontMetrics fm = g2.getFontMetrics();
            int lineSpacing = 2;

            g2.setFont(new Font("Segoe UI", Font.BOLD, 13)); // Bold Category Name
            g2.setColor(new Color(0, 0, 0));
            g2.drawString(name, x, y + fm.getAscent());
            y += fm.getHeight() + lineSpacing;

            g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            g2.setColor(Color.BLACK);
            g2.drawString("₹" + amount, x, y + fm.getAscent());
            y += fm.getHeight() + lineSpacing;

            g2.setColor(new Color(0, 102, 204));
            g2.drawString(String.format("(%.1f%%)", percent), x, y + fm.getAscent());
        }

        String capitalize(String str) {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    };

    frame.add(panel);
    frame.setVisible(true);
}

    void viewReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n** Monthly Report for ").append(LocalDate.now().getMonth()).append(" ")
                .append(LocalDate.now().getYear()).append(" **\n");
        int totalExpenses = expenses.stream().mapToInt(e -> e.amount).sum();
        int remaining = totalIncome - totalExpenses;

        report.append("------------------------------\n")
                .append("Total Income     : ₹").append(totalIncome).append("\n")
                .append("Total Expenses   : ₹").append(totalExpenses).append("\n")
                .append("Remaining Budget : ₹").append(remaining).append("\n\nExpenses:\n");

        HashMap<String, Integer> categoryTotal = new HashMap<>();
        for (Expense e : expenses) {
            categoryTotal.put(e.category, categoryTotal.getOrDefault(e.category, 0) + e.amount);
        }
        for (String cat : categoryTotal.keySet()) {
            report.append("- ").append(cat).append(" : ₹").append(categoryTotal.get(cat)).append("\n");
        }

        int savings = remaining;
        report.append("\nSavings Goal     : ₹").append(savingsGoal).append("\n")
                .append("Actual Savings   : ₹").append(savings);
        report.append(savings >= savingsGoal ? " ✅ Goal Achieved!" : " ❌ Below Goal");
       fadeInReport(report.toString()); // ✅ correct



    }

void exportReport() {
    String fileName = "report_" + LocalDate.now().getYear() + "_" + LocalDate.now().getMonthValue() + ".txt";
    File reportFile = new File(fileName);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
        writer.write("** Exported Budget Report **\n----------------------------\nIncome: ₹" + totalIncome + "\nExpenses:\n");
        for (Expense e : expenses) writer.write(e + "\n");
        JOptionPane.showMessageDialog(this, "✅ Report exported successfully!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "❌ Error exporting report.");
        return;
    }

    // ✅ Automatically open the file using system default editor
    try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(reportFile);
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ Desktop operations not supported.");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "❌ Could not open the exported file.");
    }
}




     void updateExpense() {
        if (expenses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No expenses to update.");
            return;
        }
        String[] options = expenses.stream().map(Expense::toString).toArray(String[]::new);
        String choice = (String) JOptionPane.showInputDialog(this, "Choose expense to update:", "Update Expense",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == null) return;
        int index = Arrays.asList(options).indexOf(choice);

        JTextField categoryField = new JTextField(expenses.get(index).category);
        JTextField amountField = new JTextField(String.valueOf(expenses.get(index).amount));
        JTextField dateField = new JTextField(expenses.get(index).date.toString());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        wrapper.add(panel, BorderLayout.CENTER);

        if (JOptionPane.showConfirmDialog(this, wrapper, "Update Expense", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                String newCat = categoryField.getText();
                int newAmt = Integer.parseInt(amountField.getText());
                LocalDate newDate = LocalDate.parse(dateField.getText());
                expenses.set(index, new Expense(newCat, newAmt, newDate));
                JOptionPane.showMessageDialog(this, "✅ Expense updated.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Invalid input.");
            }
        }
    }

    void deleteExpense() {
        if (expenses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No expenses to delete.");
            return;
        }
        String[] options = expenses.stream().map(Expense::toString).toArray(String[]::new);
        String choice = (String) JOptionPane.showInputDialog(this, "Choose expense to delete:", "Delete Expense",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == null) return;
        int index = Arrays.asList(options).indexOf(choice);
        Expense removed = expenses.remove(index);
        JOptionPane.showMessageDialog(this, "✅ Deleted: " + removed);
    }

    void showCategorySummary() {
        StringBuilder sb = new StringBuilder("\n** Category-wise Summary **\n------------------------------\n");
        sb.append(String.format("%-15s | %-7s | %-7s | %-15s\n", "Category", "Budget", "Spent", "Status"));
        sb.append("----------------------------------------------\n");

        for (String cat : budgetMap.keySet()) {
            int budget = budgetMap.get(cat);
            int spent = expenses.stream().filter(e -> e.category.equals(cat)).mapToInt(e -> e.amount).sum();
            String status = spent == 0 ? "✅ Not Used Yet" : (spent < budget ? "✅ Under Budget" : (spent == budget ? "⚠️ At Limit" : "❌ Over Limit"));
            sb.append(String.format("%-15s | ₹%-6d | ₹%-6d | %s\n", capitalize(cat), budget, spent, status));
        }
        fadeInReport(sb.toString());


    }

    void showMonthlyTrend() {
        StringBuilder sb = new StringBuilder("\n📊 Monthly Expense Trend\n------------------------------\n");
        sb.append("April 2025: ₹18000\nMay 2025  : ₹22600\n");
        int current = expenses.stream().mapToInt(e -> e.amount).sum();
        sb.append("June 2025 : ₹").append(current).append(" (so far)\n\n");
        sb.append(current < 10000 ? "✅ Expenses decreased in June." : "❌ High spending in June.");
        fadeInReport(sb.toString());


    }




    String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
void fadeInReport(String text) {
    final int delay = 15; // milliseconds
    final char[] chars = text.toCharArray();
    final StringBuilder currentText = new StringBuilder();
javax.swing.Timer timer = new javax.swing.Timer(delay, null);

    final int[] index = {0};

    timer.addActionListener(e -> {
        if (index[0] < chars.length) {
            currentText.append(chars[index[0]++]);
            reportArea.setText(currentText.toString());
        } else {
            timer.stop();
        }
    });

    timer.start();
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlannerguiiChart().setVisible(true));
    }
}
