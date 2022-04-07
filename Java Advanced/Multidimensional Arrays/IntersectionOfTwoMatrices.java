import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);
        char[][] outputMatrix = fillMatrix(firstMatrix, secondMatrix, rows, cols);

        printMatrix(rows, cols, outputMatrix);
    }

    private static void printMatrix(int rows, int cols, char[][] outputMatrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] fillMatrix(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] outputMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char fillChar = firstMatrix[i][j] == secondMatrix[i][j] ? firstMatrix[i][j] : '*';
                outputMatrix[i][j] = fillChar;
            }
        }
        return outputMatrix;
    }

    public static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            char[] arr = line.replaceAll("\\s+", "").toCharArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
