
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> students = new TreeMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (students.containsKey(symbol)) {
                int currentCount = students.get(symbol);
                students.put(symbol, currentCount + 1);
            } else {
                students.put(symbol, 1);
            }
        }
        students.forEach((key, value) -> System.out.println(key + ": " + value
                + " time/s"));
    }
}
