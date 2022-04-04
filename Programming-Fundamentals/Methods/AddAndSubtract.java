import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int result = subtractTheThirdInteger(n1, n2, n3);
        System.out.println(result);
    }

    public static int sumOfTheFirstTwoIntegers(int n1, int n2) {
        int result = n1 + n2;
        return result;
    }

    public static int subtractTheThirdInteger(int n1, int n2, int n3) {
        int sum = sumOfTheFirstTwoIntegers(n1, n2);
        int result = sum - n3;
        return result;
    }
}
