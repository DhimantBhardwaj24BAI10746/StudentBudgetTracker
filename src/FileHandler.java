import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_PATH = "data/expenses.txt";

    public static void saveExpenses(ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Expense expense : expenses) {
                writer.write(expense.getDate() + "," +
                             expense.getCategory() + "," +
                             expense.getAmount() + "," +
                             expense.getDescription());
                writer.newLine();
            }
            System.out.println("Expenses saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);

                if (parts.length == 4) {
                    String date = parts[0];
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String description = parts[3];

                    expenses.add(new Expense(date, category, amount, description));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in expense data format.");
        }

        return expenses;
    }
}