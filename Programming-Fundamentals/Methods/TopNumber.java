import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= n; i++) {
            if (isSumDigitsDivisible(i) && holdsOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSumDigitsDivisible(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean holdsOddDigit(int number) {
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 1) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
