import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private double monthlyBudget;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        monthlyBudget = 0;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("\n--- All Expenses ---");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public double getTotalSpent() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public void setMonthlyBudget(double budget) {
        monthlyBudget = budget;
        System.out.println("Monthly budget set to ₹" + monthlyBudget);
    }

    public double getRemainingBudget() {
        return monthlyBudget - getTotalSpent();
    }

    public void showBudgetStatus() {
        if (monthlyBudget == 0) {
            System.out.println("Monthly budget not set yet.");
            return;
        }

        double remaining = getRemainingBudget();
        System.out.println("Total Spent: ₹" + getTotalSpent());
        System.out.println("Remaining Budget: ₹" + remaining);

        if (remaining < 0) {
            System.out.println("Warning: You have exceeded your monthly budget!");
        }
    }

    public void searchByCategory(String category) {
        boolean found = false;

        System.out.println("\n--- Expenses in Category: " + category + " ---");
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                System.out.println(expense);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}
