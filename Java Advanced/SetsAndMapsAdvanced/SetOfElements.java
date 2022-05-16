import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String input = scanner.nextLine();
        int countFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int countSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        for (int i = 0; i < countFirstSet; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            firstSet.add(n);
        }

        for (int i = 0; i < countSecondSet; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            secondSet.add(n);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(n -> System.out.print(n + " "));
    }
}
