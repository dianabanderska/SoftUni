import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        double price = 0;

        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("End")) {
            if (input2.equals("Nuts")) {
                price = 2.0;
            } else if (input2.equals("Water")) {
                price = 0.7;
            } else if (input2.equals("Crisps")) {
                price = 1.5;
            } else if (input2.equals("Soda")) {
                price = 0.8;
            } else if (input2.equals("Coke")) {
                price = 1.0;
            } else {
                System.out.println("Invalid product");

            }
            if (sum >= price && price != 0) {
                sum -= price;
                System.out.printf("Purchased %s%n", input2);
                if (sum == 0) {
                    break;
                }
            } else if (price != 0)
                System.out.println("Sorry, not enough money");
            input2 = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
