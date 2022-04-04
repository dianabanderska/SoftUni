import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double output = mathPower(num, power);

        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(output));

    }

    public static double mathPower(double num, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
}
