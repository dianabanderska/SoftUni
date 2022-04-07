import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        generateMatrix(rows, cols, matrix);

        printMatrix(matrix, rows);
    }

    private static void generateMatrix(int rows, int cols, String[][] matrix) {
        char startLetter = 'a';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String palindrome = "" + startLetter + (char) (startLetter + j) + startLetter;
                matrix[i][j] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
        }
    }

    public static void printMatrix(String[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
