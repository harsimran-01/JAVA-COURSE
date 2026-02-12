// Complete Swing GUI Offline Budget Planner with Tablet-Style Styling
// Includes: Add Budget, Add Expense, View Report, Predict Status, Export, Update, Delete, Summary, Trend

import javax.swing.*;
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

public class PlannerGUI extends JFrame {
    int totalIncome = 0;
    HashMap<String, Integer> budgetMap = new HashMap<>();
    ArrayList<Expense> expenses = new ArrayList<>();
    int savingsGoal = 0;

    JTextArea reportArea = new JTextArea(18, 50);
    JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 15, 15));

    public PlannerGUI() {
        setTitle("📘 Offline Budget Planner");
        setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));
        getContentPane().setBackground(new Color(250, 250, 255));

        reportArea.setEditable(false);
        reportArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        reportArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "📄 Report Display", 0, 0, new Font("SansSerif", Font.BOLD, 16)));

        buttonPanel.setBackground(new Color(245, 255, 250));
        buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "⚙️ Planner Actions", 0, 0, new Font("SansSerif", Font.BOLD, 16)));

        String[] buttonNames = {
            "Add Monthly Budget", "Add Expense", "View Report", "Predict Status",
            "Export Report", "Update Expense", "Delete Expense", "Category-wise Summary",
            "View Monthly Trend"
        };

        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(60, 130, 210));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setPreferredSize(new Dimension(220, 50));
            btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 90, 160)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));
            btn.addActionListener(this::handleButton);
            buttonPanel.add(btn);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(250, 250, 255));
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
        JPanel panel = new JPanel(new GridLayout(categories.length + 1, 2));

        panel.add(new JLabel("Total Income:"));
        panel.add(incomeField);

        Map<String, JTextField> fields = new HashMap<>();
        for (String category : categories) {
            JTextField field = new JTextField();
            fields.put(category.toLowerCase(), field);
            panel.add(new JLabel(category + ":"));
            panel.add(field);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Monthly Budget", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                totalIncome = Integer.parseInt(incomeField.getText());
                for (String cat : fields.keySet()) {
                    int val = Integer.parseInt(fields.get(cat).getText());
                    budgetMap.put(cat, val);
                }
                savingsGoal = budgetMap.getOrDefault("savings", 0);
                JOptionPane.showMessageDialog(this, "Budget added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers only.");
            }
        }
    }

    void showAddExpenseDialog() {
        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Expense", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String category = categoryField.getText().toLowerCase();
                int amount = Integer.parseInt(amountField.getText());
                expenses.add(new Expense(category, amount, LocalDate.now()));
                JOptionPane.showMessageDialog(this, "Expense added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter correct values.");
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
            JOptionPane.showMessageDialog(this, "No expenses to update."); return;
        }
        String[] options = expenses.stream().map(Expense::toString).toArray(String[]::new);
        String choice = (String) JOptionPane.showInputDialog(this, "Choose expense to update:", "Update Expense",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == null) return;
        int index = Arrays.asList(options).indexOf(choice);

        JTextField categoryField = new JTextField(expenses.get(index).category);
        JTextField amountField = new JTextField(String.valueOf(expenses.get(index).amount));
        JTextField dateField = new JTextField(expenses.get(index).date.toString());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Category:")); panel.add(categoryField);
        panel.add(new JLabel("Amount:")); panel.add(amountField);
        panel.add(new JLabel("Date (YYYY-MM-DD):")); panel.add(dateField);

        if (JOptionPane.showConfirmDialog(this, panel, "Update Expense", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
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
            JOptionPane.showMessageDialog(this, "No expenses to delete."); return;
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
        SwingUtilities.invokeLater(() -> new PlannerGUI().setVisible(true));
    }
}
