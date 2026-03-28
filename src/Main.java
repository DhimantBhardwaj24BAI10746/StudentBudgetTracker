import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        manager.setExpenses(FileHandler.loadExpenses());

        while (true) {
            System.out.println("\n===== Student Budget Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spent");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. View Budget Status");
            System.out.println("6. Search Expense by Category");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    System.out.print("Enter category (Food/Travel/Study/Personal/Other): ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    Expense expense = new Expense(date, category, amount, description);
                    manager.addExpense(expense);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    System.out.println("Total Spent: ₹" + manager.getTotalSpent());
                    break;

                case 4:
                    System.out.print("Enter monthly budget: ");
                    double budget = sc.nextDouble();
                    manager.setMonthlyBudget(budget);
                    break;

                case 5:
                    manager.showBudgetStatus();
                    break;

                case 6:
                    System.out.print("Enter category to search: ");
                    String searchCategory = sc.nextLine();
                    manager.searchByCategory(searchCategory);
                    break;

                case 7:
                    FileHandler.saveExpenses(manager.getExpenses());
                    System.out.println("Exiting... Thank you for using Student Budget Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}