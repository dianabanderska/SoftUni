import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> calculator = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");

        Collections.addAll(calculator, input);

        while (calculator.size() > 1) {
            int first = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int second = Integer.parseInt(calculator.pop());

            switch (operator) {
                case "+":
                    calculator.push(String.valueOf(first + second));
                    break;
                case "-":
                    calculator.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(calculator.pop());
    }
}