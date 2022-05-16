import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] inputElements = input.split("\\s+");

            Collections.addAll(elements, inputElements);
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}

