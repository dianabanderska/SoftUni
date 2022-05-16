import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number =
                Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> evenNumbers = number
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        Function<Stream<Integer>, String> mutator = x -> x.map(String::valueOf)
                .collect(Collectors.joining(", "));

        String firstOutput = mutator.apply(evenNumbers.stream());

        System.out.println(firstOutput);

        String secondOutput = mutator.apply(evenNumbers
                .stream()
                .sorted());

        System.out.println(secondOutput);
    }
}

