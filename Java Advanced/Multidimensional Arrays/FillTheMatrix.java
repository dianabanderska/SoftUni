import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix, n, n);
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = startNumber++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = startNumber++;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
