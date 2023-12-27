import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        //HashMap для хранения пар товар-колво
        Map<String, Integer> salesMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить продажу");
            System.out.println("2. Вывести список продаж");
            System.out.println("3. Показать общую сумму продаж");
            System.out.println("4. Найти наиболее популярный товар");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); //чтобы после enter не перекидывало

            switch (choice) {
                case 1:
                    addSale(salesMap, scanner);
                    break;
                case 2:
                    showSalesList(salesMap);
                    break;
                case 3:
                    showTotalSales(salesMap);
                    break;
                case 4:
                    showMostPopularItem(salesMap);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    //добавление продажи в коллекцию
    private static void addSale(Map<String, Integer> salesMap, Scanner scanner) {
        System.out.println("Введите название товара:");
        String item = scanner.nextLine();

        System.out.println("Введите количество продаж:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); //чтобы после enter не перекидывало

        salesMap.put(item, salesMap.getOrDefault(item, 0) + quantity);

        System.out.println("Продажа добавлена.");
    }

    //для вывода списка продаж
    private static void showSalesList(Map<String, Integer> salesMap) {
        System.out.println("Список продаж:");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) { //в entry, все значения salsesMap
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //для вывода общей суммы продаж
    private static void showTotalSales(Map<String, Integer> salesMap) {
        int totalSales = 0;
        for (int quantity : salesMap.values()) {
            totalSales += quantity;
        }
        System.out.println("Общая сумма продаж: " + totalSales);
    }

    // вывод наиболее популярного товара
    private static void showMostPopularItem(Map<String, Integer> salesMap) {
        String mostPopularItem = "";
        int maxQuantity = 0;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                mostPopularItem = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }

        if (mostPopularItem != null) {
            System.out.println("Наиболее популярный товар: " + mostPopularItem);
        } else {
            System.out.println("Нет данных о продажах.");
        }
    }
}
