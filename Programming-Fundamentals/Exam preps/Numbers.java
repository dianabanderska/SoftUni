import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }

        double average = (double) sum / numbers.size();

        List<Integer> result = new ArrayList<>();

        for (Integer integer : numbers) {
            if (integer > average) {
                result.add(integer);
            }
        }
        List<Integer> sortedList = result.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (sortedList.size() == 0) {
            System.out.println("No");
        }else if (sortedList.size() <= 5) {
            for (Integer integer : sortedList) {
                System.out.print(integer + " ");
            }
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.print(sortedList.get(i) + " ");
            }
        }
    }
}
