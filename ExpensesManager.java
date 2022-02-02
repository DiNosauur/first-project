import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        //expensesByCategories.computeIfAbsent(category, k -> new ArrayList<>()).add(expense); // Замените на работу с таблицей
        if (!expensesByCategories.containsKey(category)) { // Проверьте наличие категории
            expensesByCategories.put(category, new ArrayList<>()); // Создайте новый список трат и добавьте в него сумму
        }
        expensesByCategories.get(category).add(expense); // Сохраните категорию и новый список трат в хеш-таблицу
        if (moneyBeforeSalary < 1000) {
           System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expense : expensesByCategories.get(category)) {
                System.out.println(expense.doubleValue());
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (!expensesByCategories.containsKey(category)) {
            System.out.println("Такой категории пока нет.");
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
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() { // Напишите метод для получения суммы всех трат
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

    // Напишите метод для получения категории, где размер трат больше всего
    // Используйте эти переменные для сохранения промежуточных значений
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