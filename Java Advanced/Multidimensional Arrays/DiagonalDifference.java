import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(scanner, n, matrix);

        int sumPrimary = getSumPrimaryDiagonal(matrix);

        int sumSecondary = getSumSecondDiagonal(matrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));

    }

    private static int getSumSecondDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j <= matrix[i].length; j++) {
                if (j == matrix.length - i - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
