import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNumbers = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;

        for (int i = 1; i <= cityNumbers; i++) {
            String cityName = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());
            if (i % 5 == 0) {
                income -= income * 0.10;
            } else if (i % 3 == 0) {
                expenses += expenses * 0.50;
            }
            double profit = income - expenses;
            totalProfit += profit;

            System.out.printf("In %s Burger Bus earned %.2f leva.%n", cityName, profit);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
