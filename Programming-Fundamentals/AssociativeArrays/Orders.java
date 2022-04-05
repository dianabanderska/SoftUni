import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> products = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] dataArr = input.split("\\s+");
            String name = dataArr[0];
            Double price = Double.parseDouble(dataArr[1]);
            Double quantity = Double.parseDouble(dataArr[2]);

            if (!products.containsKey(name)) {
                products.put(name, new ArrayList<>());
                products.get(name).add(price);
                products.get(name).add(quantity);
            } else {
                double currentQuantity = products.get(name).get(1);
                products.get(name).set(0, price);
                products.get(name).set(1, currentQuantity + quantity);
            }
            input = scanner.nextLine();
        }
        Map<String, Double> totalProductsPrice = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : products.entrySet()) {
            List<Double> values = entry.getValue();
            String studentName = entry.getKey();
            double sum = getTotalPriceOfProducts(values);
            totalProductsPrice.put(studentName, sum);
        }
        totalProductsPrice.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }

    private static double getTotalPriceOfProducts(List<Double> values) {
        double sum = 1;
        for (double value : values) {
            sum *= value;
        }
        return sum;
    }
}
