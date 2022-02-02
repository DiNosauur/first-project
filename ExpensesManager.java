import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // �������� �� ������� � ������ expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // �������� �������
    }

    // �������� � ����� ��� ���� �������� � category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("�������� ���������! ��� ������� ������ � ������: " + moneyBeforeSalary);
        //expensesByCategories.computeIfAbsent(category, k -> new ArrayList<>()).add(expense); // �������� �� ������ � ��������
        if (!expensesByCategories.containsKey(category)) { // ��������� ������� ���������
            expensesByCategories.put(category, new ArrayList<>()); // �������� ����� ������ ���� � �������� � ���� �����
        }
        expensesByCategories.get(category).add(expense); // ��������� ��������� � ����� ������ ���� � ���-�������
        if (moneyBeforeSalary < 1000) {
           System.out.println("�� ����� ����� �������� ������ �������. ����� ������ ���������!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // �������� ������ ��� ������ � ���������
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expense : expensesByCategories.get(category)) {
                System.out.println(expense.doubleValue());
            }
        }
    }

    // ����� ������ ��������� �������� ��������� � ���������� findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        /* �������� ������ ��� ������ � ���������
        ���� ��������� ����, �� ���� ����������� �����.
        ����� �������� "����� ��������� ���� ���." */
        if (!expensesByCategories.containsKey(category)) {
            System.out.println("����� ��������� ���� ���.");
        } else {
           for (Double expense : expensesByCategories.get(category)) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // ������� ���������� �����
        System.out.println("����� �������.");
    }

    double getExpensesSum() { // �������� ����� ��� ��������� ����� ���� ����
        double result = 0.0;
        for (String category : expensesByCategories.keySet()) {
            for (Double expense : expensesByCategories.get(category)) {
                result += expense;
            }
        }
        return result;
    }

    void removeCategory(String name) {
        expensesByCategories.remove(name);
    }

    // �������� ����� ��� ��������� ���������, ��� ������ ���� ������ �����
    // ����������� ��� ���������� ��� ���������� ������������� ��������
    String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";
        double sum;
        for (String category : expensesByCategories.keySet()) {
            sum = 0;
            for (Double expense : expensesByCategories.get(category)) {
                sum += expense;
            }
            if (sum > maxCategorySum) {
                maxCategorySum = sum;
                maxCategoryName = category;
            }
        }
        return maxCategoryName;
    }
}