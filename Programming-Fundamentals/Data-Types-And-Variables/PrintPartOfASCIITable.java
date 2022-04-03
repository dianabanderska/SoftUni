import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = num; i <= secondNum; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}
