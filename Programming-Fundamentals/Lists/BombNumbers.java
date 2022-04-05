
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        while (numbers.contains(bomb)) {
            int bombIndex = numbers.indexOf(bomb);
            int start = Math.max(bombIndex - power, 0);
            int end = Math.min(bombIndex + power, numbers.size() - 1);

            for (int i = start; i <= end; i++) {
                numbers.remove(start);
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}