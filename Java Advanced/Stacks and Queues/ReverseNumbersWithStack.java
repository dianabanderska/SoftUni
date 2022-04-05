import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numbers::push);

        numbers.forEach(string -> System.out.print(string + " "));
    }
}
