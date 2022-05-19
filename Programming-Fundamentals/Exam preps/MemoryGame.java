import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int moves = 0;
        while (!input.equals("end")) {
            moves++;
            String[] tokens = input.split("\\s+");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);
            if (index1 == index2 || index1 < 0 || index1 > elements.size() - 1 || index2 < 0 || index2 >
                    elements.size() - 1) {
                addNewElements(elements, moves);
                System.out.println("Invalid input! Adding additional elements to the board");
            }else if (elements.get(index1).equals(elements.get(index2))) {
                String element = elements.get(index1);
                elements.remove(index1);
                if (index2 == 0) {
                    elements.remove(index2);
                }else {
                    elements.remove(index2 - 1);
                }
                System.out.printf("Congrats! You have found matching elements - %s!%n", element);
            } else {
                System.out.println("Try again!");
            }
            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", moves);
                break;
            }
            input = scanner.nextLine();
        }
        if (!elements.isEmpty()) {
            System.out.println("Sorry you lose :(");
            print(elements);
        }
    }

    public static void addNewElements(List<String> elements, int moves) {
        int index1 = elements.size() / 2;
        int index2 = elements.size() / 2 + 1;
        String newElement = (String.format("-%da", moves));
        elements.add(index1, newElement);
        elements.add(index2, newElement);
    }
    public static void print(List<String> elements) {
        elements.forEach(e -> System.out.print(e + " "));
    }
}
