import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);

        int[][] firstMatrix = readMatrix(rows, scanner);

        rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);

        int[][] secondMatrix = readMatrix(rows, scanner);

        boolean areEqual = areEqual(firstMatrix, secondMatrix);

        String output = areEqual ? "equal" : "not equal";

        System.out.println(output);
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int j = 0; j < firstArr.length; j++) {
                if (firstArr[j] != secondArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }
        return matrix;
    }
}
