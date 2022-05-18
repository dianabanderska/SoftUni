import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double sqrt = sqrt(scanner);
            System.out.printf("%.2f%n", sqrt);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye");
        }
    }

    public static double sqrt(Scanner scanner) {
        String str = scanner.nextLine();

        for (char symbol : str.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                throw new NumberFormatException("Invalid");
            }
        }
        int number = Integer.parseInt(str);

        return Math.sqrt(number);
    }
}
