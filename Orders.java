import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOrders = Integer.parseInt(scanner.nextLine());
        double total = 0;

        for (int i = 0; i < countOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double sum = (pricePerCapsule * days) * capsulesCount;
            total += sum;
            System.out.printf("The price for the coffee is: $%.2f%n", sum);
        }
        System.out.printf("Total: $%.2f", total);
    }
}
