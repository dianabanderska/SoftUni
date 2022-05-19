import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeeList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "Include":
                    String coffeeToAdd = commands[1];
                    coffeeList.add(coffeeToAdd);
                    break;
                case "Remove":
                    String position = commands[1];
                    int numberOfCoffees = Integer.parseInt(commands[2]);
                    if (isValidIndex(numberOfCoffees, coffeeList)) {
                        if (position.equals("first")) {
                            removeFirst(coffeeList, numberOfCoffees);
                        } else if (commands[1].equals("last")) {
                            removeLast(coffeeList, numberOfCoffees);
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commands[1]);
                    int index2 = Integer.parseInt(commands[2]);
                    if (isValidIndexes(coffeeList, index1, index2)) {
                        changePlaces(coffeeList, index1, index2);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;
            }
        }
        System.out.printf("Coffees:%n");
        System.out.println(String.join(" ", coffeeList));

    }

    private static void removeLast(List<String> coffeeList, int numberOfCoffees) {
        for (int i = 0; i < numberOfCoffees; i++) {
            coffeeList.remove(coffeeList.size() - 1);
        }
    }

    private static void removeFirst(List<String> coffeeList, int numberOfCoffees) {
        for (int i = 0; i < numberOfCoffees; i++) {
            coffeeList.remove(0);
        }
    }

    private static void changePlaces(List<String> coffeeList, int index1, int index2) {
        String firstCoffee = coffeeList.get(index1);
        String secondCoffee = coffeeList.get(index2);
        coffeeList.set(index1, secondCoffee);
        coffeeList.set(index2, firstCoffee);
    }

    private static boolean isValidIndexes(List<String> coffeeList, int index1, int index2) {
        return index1 >= 0 && index1 < coffeeList.size() && index2 >= 0 && index2 < coffeeList.size();
    }

    private static boolean isValidIndex(int numberOfCoffees, List<String> coffeeList) {
        return numberOfCoffees >= 0 && numberOfCoffees < coffeeList.size();
    }
}
