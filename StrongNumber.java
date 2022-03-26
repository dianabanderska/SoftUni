import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int startNum = num1;
        int sumFactDigit = 0;

        while (num1 != 0) {
            int lastDigit = num1 % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            sumFactDigit += fact;
            num1 /= 10;
        }

        if (sumFactDigit == startNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
