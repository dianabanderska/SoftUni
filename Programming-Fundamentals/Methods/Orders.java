import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (product) {
            case "coffee":
                price = 1.50;
                coffee(price, count);
                break;
            case "water":
                price = 1;
                water(price, count);
                break;
            case "coke":
                price = 1.40;
                coke(price, count);
                break;
            case "snacks":
                price = 2;
                snacks(price, count);
                break;
        }
    }

    public static void coffee(double price, int count) {
        double result = price * count;
        System.out.printf("%.2f", result);
    }

    public static void water(double price, int count) {
        double result = price * count;
        System.out.printf("%.2f", result);
    }

    public static void coke(double price, int count) {
        double result = price * count;
        System.out.printf("%.2f", result);

    }

    public static void snacks(double price, int count) {
        double result = price * count;
        System.out.printf("%.2f", result);
    }
}
