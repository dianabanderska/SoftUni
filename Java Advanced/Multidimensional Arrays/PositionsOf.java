import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int number = Integer.parseInt(scanner.nextLine());

        findNumberInMatrix(matrix, number);
    }

    private static void findNumberInMatrix(int[][] matrix, int number) {
        boolean isNumberFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (current == number) {
                    isNumberFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isNumberFound) {
            System.out.println("not found");
        }
    }
}
