import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTaxes = 0;
        double taxes = 0;
        double totalPrice = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            } else if (price == 0) {
                System.out.println("Invalid order!");
                input = scanner.nextLine();
                continue;
            } else {
                priceWithoutTaxes += price;
                taxes += price * 0.20;
                totalPrice = priceWithoutTaxes + taxes;
            }
            input = scanner.nextLine();
        }
        if (input.equals("special")) {
            totalPrice -= totalPrice * 0.10;
        }
        if (priceWithoutTaxes == 0) {
            System.out.println("Invalid order!");
        }else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
