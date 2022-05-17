import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        char color = scanner.nextLine().charAt(0);

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startRow = dimensions[0];
        int startCol = dimensions[1];

        char oldColor = matrix[startRow][startCol];

        colorPlane(matrix, startRow, startCol, color, oldColor);

        printMatrix(matrix);
    }

    private static void colorPlane(char[][] matrix, int startRow, int startCol, char color, char oldColor) {
        if (isOutOfBounds(matrix, startRow, startCol)) {
            return;
        }
        if (matrix[startRow][startCol] != oldColor) {
            return;
        }
        matrix[startRow][startCol] = color;

        colorPlane(matrix, startRow + 1, startCol, color, oldColor);
        colorPlane(matrix, startRow - 1, startCol, color, oldColor);
        colorPlane(matrix, startRow, startCol + 1, color, oldColor);
        colorPlane(matrix, startRow, startCol - 1, color, oldColor);
    }

    private static boolean isOutOfBounds(char[][] matrix, int startRow, int startCol) {
        return startRow >= matrix.length || startRow < 0
                || startCol >= matrix[startRow].length || startCol < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char e : arr) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
