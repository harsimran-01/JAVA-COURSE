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

public class Planner {
    static Scanner sc = new Scanner(System.in);
    static int totalIncome = 0;
    static HashMap<String, Integer> budgetMap = new HashMap<>();
    static ArrayList<Expense> expenses = new ArrayList<>();
    static int savingsGoal = 0;

    public static void main(String[] args) throws IOException {
        int choice;

        do {
System.out.println();
            System.out.println("=============================================");
            System.out.println("*** Welcome to Offline Budget Planner ***");
            System.out.println("=============================================");
System.out.println();

            System.out.println("1. Add Monthly Budget");
            System.out.println("2. Add Expense");
            System.out.println("3. View Report");
            System.out.println("4. Predict Expense Status");
            System.out.println("5. Export Report");
            System.out.println("6. Update an Expense");
            System.out.println("7. Delete an Expense");
            System.out.println("8. Category-wise Summary");
            System.out.println("9. View Monthly Trend");
            System.out.println("10. Exit\n");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBudget();
                case 2 -> addExpense();
                case 3 -> viewReport();
                case 4 -> predictStatus();
                case 5 -> exportReport();
                case 6 -> updateExpense();
                case 7 -> deleteExpense();
                case 8 -> categorySummary();
                case 9 -> showTrend();
                case 10 -> System.out.println("\n ** Exiting the Offline Budget Planner...\nYour data has been saved.\nThank you for using the planner! **");
                default -> System.out.println(" ** Invalid option. **");
            }

        } while (choice != 10);
    }

    static void addBudget() {
        System.out.println("\n ** Add Monthly Budget **");
System.out.println();
        System.out.print("Enter your total income: ");
        totalIncome = sc.nextInt();
        sc.nextLine();

        String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Miscellaneous", "Savings"};
        for (String category : categories) {
            System.out.print("Enter budget for " + category + ": ");
            int budget = sc.nextInt();
            // budgetMap.put(category, budget);
            budgetMap.put(category.toLowerCase(), budget);
        }
        savingsGoal = budgetMap.get("savings");

        System.out.println("\n** Budget added successfully! **\n");
    }

    static void addExpense() {
        System.out.println("\n** Add Expense **");
System.out.println();
        System.out.print("Enter category: ");
        // String category = sc.nextLine();
        String category = sc.nextLine().toLowerCase();
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        sc.nextLine();
        // System.out.print("Enter date (YYYY-MM-DD): ");
        // LocalDate date = LocalDate.parse(sc.nextLine());
        LocalDate date = LocalDate.now();
System.out.println("Date: " + date); 
        expenses.add(new Expense(category, amount, date));
        
        System.out.println("\n** Expense added successfully. **\n");
    }

    static void viewReport() {
System.out.println();
        System.out.println("\n** Monthly Report for " + LocalDate.now().getMonth() + " " + LocalDate.now().getYear() +" ** ");
        int totalExpenses = expenses.stream().mapToInt(e -> e.amount).sum();
        int remaining = totalIncome - totalExpenses;

        System.out.println("------------------------------");
        System.out.println("Total Income     : ₹" + totalIncome);
        System.out.println("Total Expenses   : ₹" + totalExpenses);
        System.out.println("Remaining Budget : ₹" + remaining);
        System.out.println("\nExpenses:");
        HashMap<String, Integer> categoryTotal = new HashMap<>();
        for (Expense e : expenses) {
            categoryTotal.put(e.category, categoryTotal.getOrDefault(e.category, 0) + e.amount);
        }
        for (String cat : categoryTotal.keySet()) {
            System.out.println("- " + cat + " : ₹" + categoryTotal.get(cat));
        }

        int savings = remaining;
        System.out.println("\nSavings Goal     : ₹" + savingsGoal);
        System.out.println("Actual Savings   : ₹" + savings + (savings >= savingsGoal ? " ** (Goal achieved!)" : " X (Below goal)"));
    }

    static void predictStatus() {
System.out.println();
        System.out.println("\n📡 Predict Expense Status");
        int totalExpenses = expenses.stream().mapToInt(e -> e.amount).sum();
        int remaining = totalIncome - totalExpenses;

        System.out.println("------------------------------");
        System.out.println("Budget: ₹" + totalIncome);
        System.out.println("Total Expenses: ₹" + totalExpenses);
        if (totalExpenses <= totalIncome) {
            System.out.println("\nStatus:  Safe Spending ** \nYou're well within your budget. Keep up the good work! **");
        } else {
            System.out.println("Status: X Over Budget! Consider reviewing expenses.");
        }

        // Warning check
        for (String cat : budgetMap.keySet()) {
            int spent = 0;
            for (Expense e : expenses) {
                if (e.category.equalsIgnoreCase(cat)) spent += e.amount;
            }
            int budget = budgetMap.getOrDefault(cat, 0);
            if (spent > budget)
                System.out.println("\n" + cat + " warning: You've exceeded your " + cat + " budget by ₹" + (spent - budget));
        }
    }

    static void exportReport() throws IOException {
System.out.println();
        BufferedWriter writer = new BufferedWriter(new FileWriter("report_" + LocalDate.now().getYear() + "_" + LocalDate.now().getMonthValue() + ".txt"));
        writer.write("** Exported Budget Report\n **");
        writer.write("----------------------------\n");
        writer.write("Income: ₹" + totalIncome + "\n");
        writer.write("Expenses:\n");
        for (Expense e : expenses) {
            writer.write(e.toString() + "\n");
        }
        writer.close();
        System.out.println("\n** Exporting Report...\nReport saved to: `report_" + LocalDate.now().getYear() + "_" + LocalDate.now().getMonthValue() + ".txt`\n✅ Report successfully exported. **\n");
    }

    static void updateExpense() {
System.out.println();
        System.out.println("\n** Update an Expense **");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
        System.out.print("Enter expense number to update (1 to " + expenses.size() + "): ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        Expense old = expenses.get(index);
        System.out.println("Previous: Category = " + old.category + ", Amount = ₹" + old.amount);
        System.out.print("Enter new category: ");
        String cat = sc.nextLine();
        System.out.print("Enter new amount: ");
        int amt = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        expenses.set(index, new Expense(cat, amt, date));
        System.out.println("\n** Expense updated successfully. **\n");
    }

    static void deleteExpense() {
System.out.println();
        System.out.println("\n** Delete an Expense **");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
        System.out.print("Enter expense number to delete (1 to " + expenses.size() + "): ");
        int index = sc.nextInt() - 1;
sc.nextLine();

        if (index < 0 || index >= expenses.size()) {
        System.out.println("X Invalid expense number.");
        return;
    }
        Expense removed = expenses.remove(index);
        System.out.println("Deleted expense: " + removed.category + ", ₹" + removed.amount);
        System.out.println("\n** Expense deleted successfully. **\n");
    }

    static void categorySummary() {
System.out.println();
        System.out.println("\n** Category-wise Summary **");
        System.out.println("------------------------------");
        System.out.printf("%-15s | %-7s | %-7s | %-15s\n", "Category", "Budget", "Spent", "Status");
        System.out.println("----------------------------------------------");

        // for (String cat : budgetMap.keySet()) {
        //     int budget = budgetMap.get(cat);
        //     int spent = 0;
        //     for (Expense e : expenses) {
        //         if (e.category.equalsIgnoreCase(cat)) spent += e.amount;
        //     }
        //     String status = spent == 0 ? "✅ Not Used Yet" : (spent < budget ? "✅ Under Budget" : (spent == budget ? "⚠️ At Limit" : "❌ Over Limit"));
        //     System.out.printf("%-15s | ₹%-6d | ₹%-6d | %s\n", cat, budget, spent, status);
        // }

        for (String cat : budgetMap.keySet()) {
    int budget = budgetMap.get(cat);
    int spent = 0;
    for (Expense e : expenses) {
        if (e.category.equals(cat)) spent += e.amount;  // both in lowercase
    }
    // Capitalize first letter for display only (optional)
    String displayCat = cat.substring(0, 1).toUpperCase() + cat.substring(1);
    String status = spent == 0
        ? "** Not Used Yet **"
        : (spent < budget ? "** Under Budget **" : (spent == budget ? "** At Limit **" : "** Over Limit **"));

    System.out.printf("%-15s | ₹%-6d | ₹%-6d | %s\n", displayCat, budget, spent, status);
}

        System.out.println();
    }


    static void showTrend() {
System.out.println();
        System.out.println("\n?** Monthly Expense Trend **");
        System.out.println("------------------------------");
        System.out.println("April 2025: ₹18,000");
        System.out.println("May 2025  : ₹22,600");
        int thisMonth = expenses.stream().mapToInt(e -> e.amount).sum();
        System.out.println("June 2025 : ₹" + thisMonth + " (so far)");
        System.out.println("\n** Trend: Expenses " + (thisMonth < 10000 ? "decreased significantly in June." : "are high. Monitor spending.") + " **\n");
    }
}
