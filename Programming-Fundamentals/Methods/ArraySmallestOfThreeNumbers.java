import java.util.Arrays;
import java.util.Scanner;

public class ArraySmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[]{firstNumber, secondNumber, thirdNumber};

        int smallestNumber = getSmallestNumber(numbers);

        System.out.println(smallestNumber);
    }

    private static int getSmallestNumber(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (currentNum < min) {
                min = currentNum;
            }
        }
        return min;
    }
}
