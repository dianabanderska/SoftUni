import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows, scanner, "\\s+");

        printMatrix(rows, matrix);
    }

    private static void printMatrix(int rows, int[][] matrix) {
        int row = 0;
        int col = 0;
        while (row < rows && col < rows) {
            int current = matrix[row][col];
            System.out.print(current + " ");
            row++;
            col++;
        }
        System.out.println();

        row = rows - 1;
        col = 0;

        while (row >= 0 && col < rows) {
            int curent = matrix[row][col];
            System.out.print(curent + " ");
            row--;
            col++;
        }
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
}
