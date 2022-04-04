import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int n2 = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println(df.format(calculate(n1, operator, n2)));
    }

    public static double calculate(int n1, String operator, int n2) {
        double result = 0;
        switch (operator) {
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
        }
        return result;
    }
}