import java.util.*;

public class OfflineBuggetPlanner{
public static void main(String args[]){

int choice;

do{
System.out.println("Welcome to Our OFFLINE BUGGET PLANNER");
System.out.println("1. Add Monthly Bugget");
System.out.println("2. Add Expense");
System.out.println("3. View Report");
System.out.println("4. Predict Report Status");
System.out.println("5. Export Report");
System.out.println("6. Update an Expense");
System.out.println("7. Delete an Expense");
System.out.println("8. Category Wise Summary");
System.out.println("9. Set/Check Saving Goal");
System.out.println("10. Monthly Trend");
System.out.println("11. Exit \n");

System.out.print(">");

choice = sc.nextInt();
sc.nextLine();

switch(choice){
case 1 : addBugget();
case 2 : addExpense();
case 3 : viewReport();
case 4 : addBugget();
case 5 : addBugget();
case 6 : addBugget();
case 7 : addBugget();
case 8 : addBugget();
case 9 : addBugget();
case 10 : addBugget();

}


}while(choice != 11);

}

static void addBugget(){}
static void addExpense(){}
static void viewReport(){}
static void reportStatus(){}
static void exportReport(){}
static void updateExpense(){}
static void deleteExpense(){}
static void summary(){}
static void savingGoal(){}
static void monthlyTrend(){}
static void exit(){}



}