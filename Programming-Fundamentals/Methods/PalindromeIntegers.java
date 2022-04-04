
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {

            System.out.println(isPalindromeIntegers(input));

            input = scanner.nextLine();
        }
    }

    public static String firstInteger(String input) {
        StringBuilder sum = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            sum.append(currentSymbol);
        }
        return sum.toString();
    }

    public static boolean isPalindromeIntegers(String input) {
        StringBuilder sum2 = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char currentSymbol = input.charAt(i);
            sum2.append(currentSymbol);
        }
        String sum2ToString = sum2.toString();
        if (firstInteger(input).equals(sum2ToString)) {
            return true;
        }
        return false;
    }
}

