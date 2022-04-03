import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (char symbol1 = 'a'; symbol1 < 'a' + num; symbol1++) {
            for (char symbol2 = 'a'; symbol2 < 'a' + num; symbol2++) {
                for (char symbol3 = 'a'; symbol3 < 'a' + num; symbol3++) {
                    System.out.printf("%c%c%c%n", symbol1, symbol2, symbol3);
                }
            }
        }
    }
}
