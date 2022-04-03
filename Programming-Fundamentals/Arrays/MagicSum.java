import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(scanner.nextLine());
        int currentNum = 0;
        int currentNum2 = 0;

        for (int i = 0; i < numArr.length; i++) {
            currentNum = numArr[i];
            for (int j = i + 1; j < numArr.length; j++) {
                currentNum2 = numArr[j];
                if (currentNum + currentNum2 == num) {
                    System.out.print(currentNum + " " + currentNum2);
                    System.out.println();
                }
            }
        }
    }
}
