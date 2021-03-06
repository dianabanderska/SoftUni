import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String[], Integer> countIntegersInString = str -> str.length;

        Function<String[], Integer> sumIntegersInString = str ->
                Arrays.stream(input)
                        .mapToInt(Integer::parseInt)
                        .sum();

        System.out.println("Count = " + countIntegersInString.apply(input));
        System.out.println("Sum = " + sumIntegersInString.apply(input));
    }
}

