import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsWithPrices = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] params = input.split(", ");
            String shop = params[0];
            String product = params[1];
            double price = Double.parseDouble(params[2]);

            shopsWithPrices.putIfAbsent(shop, new LinkedHashMap<>());

            Map<String, Double> productsAndPrices = shopsWithPrices.get(shop);
            productsAndPrices.put(product, price);

            input = scanner.nextLine();
        }

        for (String shop : shopsWithPrices.keySet()) {
            System.out.println(shop + "->");
            for (var entry : shopsWithPrices.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
