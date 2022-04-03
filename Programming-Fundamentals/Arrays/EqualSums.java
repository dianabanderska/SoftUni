
import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isFound = false;

        for (int index = 0; index < numArr.length; index++) {
            int currentElement = numArr[index];
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < index; j++) {
                leftSum += numArr[j];
            }
            for (int k = index + 1; k < numArr.length; k++) {
                rightSum += numArr[k];
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}

