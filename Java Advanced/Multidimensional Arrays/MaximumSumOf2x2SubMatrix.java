import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);

        int[][] matrix = readMatrix(rows, scanner, ", ");

        int[][] maxMatrix = new int[2][2];

        findTheBiggestSum(matrix, maxMatrix);
    }

    private static void findTheBiggestSum(int[][] matrix, int[][] maxMatrix) {
        int maxSum = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int current = matrix[i][j];
                int rightElement = matrix[i][j + 1];
                int inBelow = matrix[i + 1][j];
                int belowRight = matrix[i + 1][j + 1];

                int currentSum = current + rightElement + inBelow + belowRight;

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    maxMatrix = new int[][]{
                            {current, rightElement},
                            {inBelow, belowRight}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(maxSum);
    }

    public static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
