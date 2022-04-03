import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLenght = Math.max(firstArr.length, secondArr.length);
        int sum = 0;
        boolean isNotIdentical = false;
        for (int i = 0; i < maxLenght; i++) {
            sum += firstArr[i];
            if (firstArr[i] != secondArr[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isNotIdentical = true;
                break;
            }
        }
        if (!isNotIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
