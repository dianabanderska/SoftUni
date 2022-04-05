import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numList.removeIf(n -> n < 0);
        Collections.reverse(numList);
        System.out.println();

        if (numList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
