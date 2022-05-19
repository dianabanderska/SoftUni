import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Craft!")) {
            String[] tokens = command.split(" - ");
            String firstCommand = tokens[0];
            switch (firstCommand) {
                case "Collect":
                    String item = tokens[1];
                    if (!isItemExist(inventory, item)) {
                        inventory.add(item);
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Drop":
                    item = tokens[1];
                    if (isItemExist(inventory, item)) {
                        inventory.remove(item);
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Combine Items":
                    item = tokens[1];
                    String[] newCommand = item.split(":");
                    String oldItem = newCommand[0];
                    String newItem = newCommand[1];
                    if (!isItemExist(inventory, oldItem)) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        combineItems(inventory, oldItem, newItem);
                    }
                    break;
                case "Renew":
                    item = tokens[1];
                    if (!isItemExist(inventory, item)) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        changePosition(inventory, item);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        print(inventory);
    }

    private static void print(List<String> inventory) {
        System.out.println(String.join(", ", inventory));
    }

    private static void changePosition(List<String> inventory, String item) {
        int indexToRemove = inventory.indexOf(item);
        inventory.add(item);
        inventory.remove(indexToRemove);
    }

    private static boolean isItemExist(List<String> inventory, String item) {
        return inventory.contains(item);
    }

    private static void combineItems(List<String> inventory, String oldItem, String newItem) {
        int index = inventory.indexOf(oldItem);
        inventory.add(index + 1, newItem);
    }
}
