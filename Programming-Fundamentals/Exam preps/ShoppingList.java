import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> products = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];
            switch (firstCommand) {
                case "Urgent":
                    String item = tokens[1];
                    add(products, item);
                    break;
                case "Unnecessary":
                    item = tokens[1];
                    remove(products, item);
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    correct(products, oldItem, newItem);
                    break;
                case "Rearrange":
                    item = tokens[1];
                    rearrange(products, item);
                    break;
            }
            command = scanner.nextLine();
        }
        print(products);
    }

    private static void print(List<String> products) {
        System.out.println(String.join(", ", products));
    }

    private static void rearrange(List<String> products, String item) {
        if (products.contains(item)) {
            int productIndex = products.indexOf(item);
            products.add(item);
            products.remove(productIndex);
        }
    }

    private static void correct(List<String> products, String oldItem, String newItem) {
        if (products.contains(oldItem)) {
            int index = products.indexOf(oldItem);
            products.set(index, newItem);
        }
    }

    private static void remove(List<String> products, String item) {
        if (products.contains(item)) {
            products.remove(item);
        }
    }

    private static void add(List<String> products, String item) {
        if (!products.contains(item)) {
            products.add(0, item);
        }
    }
}
