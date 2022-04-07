import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimension = scanner.nextLine();
        int rows = Integer.parseInt(dimension.split("\\s+")[0]);
        int cols = Integer.parseInt(dimension.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, matrix, rows);

        String command = scanner.nextLine();

        swapElements(scanner, rows, cols, matrix, command);
    }

    private static void swapElements(Scanner scanner, int rows, int cols, String[][] matrix, String command) {
        while (!command.equals("END")) {
            if (!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];

                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;

                printMatrix(matrix, rows, cols);
            }
            command = scanner.nextLine();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        if (commandParts.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols
                || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
