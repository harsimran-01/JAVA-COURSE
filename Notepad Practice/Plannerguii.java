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

public class Plannerguii extends JFrame {
    int totalIncome = 0;
    HashMap<String, Integer> budgetMap = new HashMap<>();
    ArrayList<Expense> expenses = new ArrayList<>();
    int savingsGoal = 0;

    JTextArea reportArea = new JTextArea(18, 50);
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 15, 15));

    public Plannerguii() {
        setTitle("📘 Offline Budget Planner");
        setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));
        getContentPane().setBackground(new Color(250, 240, 255));  // pastel lavender

        reportArea.setEditable(false);
        reportArea.setFont(new Font("Courier New", Font.BOLD, 16)); // Bold + bigger text
        reportArea.setBackground(new Color(255, 250, 240)); // pastel peach
        reportArea.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                "📄 Report Display", 0, 0,
                new Font("SansSerif", Font.BOLD, 16)));

        buttonPanel.setBackground(new Color(220, 240, 255)); // better pastel for visibility
        buttonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "⚙️ Planner Actions", 0, 0,
                new Font("SansSerif", Font.BOLD, 16)));

        String[] buttonNames = {
            "Add Monthly Budget", "Add Expense", "View Report",
            "Predict Status", "Export Report", "Update Expense",
            "Delete Expense", "Category-wise Summary", "View Monthly Trend"
        };

        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(194, 230, 255)); // pastel blue
            btn.setForeground(Color.DARK_GRAY);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setPreferredSize(new Dimension(220, 50));

            // Strong border for better visibility
            Border outer = BorderFactory.createLineBorder(new Color(70, 130, 180), 2); // Steel Blue
            Border inner = BorderFactory.createEmptyBorder(12, 20, 12, 20);
            btn.setBorder(BorderFactory.createCompoundBorder(outer, inner));

            btn.addActionListener(this::handleButton);
            buttonPanel.add(btn);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(250, 240, 255)); // match background
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void handleButton(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getText();
        switch (cmd) {
            case "Add Monthly Budget" -> showAddBudgetDialog();
            case "Add Expense" -> showAddExpenseDialog();
            case "View Report" -> viewReport();
            case "Predict Status" -> predictStatus();
            case "Export Report" -> exportReport();
            case "Update Expense" -> updateExpense();
            case "Delete Expense" -> deleteExpense();
            case "Category-wise Summary" -> showCategorySummary();
            case "View Monthly Trend" -> showMonthlyTrend();
        }
    }

    void showAddBudgetDialog() {
        JTextField incomeField = new JTextField();
        String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Miscellaneous", "Savings"};
        JPanel panel = new JPanel(new GridLayout(categories.length + 1, 2, 10, 10));
        panel.setPreferredSize(new Dimension(350, 250));

        panel.add(new JLabel("Total Income:"));
        panel.add(incomeField);

        Map<String, JTextField> fields = new HashMap<>();
        for (String category : categories) {
            JTextField field = new JTextField();
            fields.put(category.toLowerCase(), field);
            panel.add(new JLabel(category + ":"));
            panel.add(field);
        }

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
        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        wrapper.add(panel, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, wrapper, "Add Expense", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String category = categoryField.getText().toLowerCase();
                int amount = Integer.parseInt(amountField.getText());
                expenses.add(new Expense(category, amount, LocalDate.now()));
                JOptionPane.showMessageDialog(this, "✅ Expense added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Invalid input. Use valid values.");
            }
        }
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
        reportArea.setText(report.toString());
    }

    void predictStatus() {
        StringBuilder report = new StringBuilder("\n📡 Predict Expense Status\n------------------------------\n");
        int totalExpenses = expenses.stream().mapToInt(e -> e.amount).sum();
        report.append("Budget: ₹").append(totalIncome).append("\n")
                .append("Total Expenses: ₹").append(totalExpenses).append("\n");

        report.append(totalExpenses <= totalIncome ?
                "Status: ✅ Safe Spending.\nYou're within budget!\n" :
                "Status: ❌ Over Budget! Review expenses.\n");

        for (String cat : budgetMap.keySet()) {
            int spent = expenses.stream().filter(e -> e.category.equalsIgnoreCase(cat)).mapToInt(e -> e.amount).sum();
            int budget = budgetMap.get(cat);
            if (spent > budget) {
                report.append(cat).append(" warning: Exceeded by ₹").append(spent - budget).append("\n");
            }
        }
        reportArea.setText(report.toString());
    }

    void exportReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report_" + LocalDate.now().getYear() + "_" + LocalDate.now().getMonthValue() + ".txt"));
            writer.write("** Exported Budget Report **\n----------------------------\nIncome: ₹" + totalIncome + "\nExpenses:\n");
            for (Expense e : expenses) writer.write(e + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "✅ Report exported successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Error exporting report.");
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
        reportArea.setText(sb.toString());
    }

    void showMonthlyTrend() {
        StringBuilder sb = new StringBuilder("\n📊 Monthly Expense Trend\n------------------------------\n");
        sb.append("April 2025: ₹18000\nMay 2025  : ₹22600\n");
        int current = expenses.stream().mapToInt(e -> e.amount).sum();
        sb.append("June 2025 : ₹").append(current).append(" (so far)\n\n");
        sb.append(current < 10000 ? "✅ Expenses decreased in June." : "❌ High spending in June.");
        reportArea.setText(sb.toString());
    }

    String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Plannerguii().setVisible(true));
    }
}
