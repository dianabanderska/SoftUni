import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] array1 = firstLine.split("\\s+");
        String[] array2 = secondLine.split("\\s+");

        for (String elementInSecond : array2) {
            for (String elementInFirst : array1) {
                if (elementInSecond.equals(elementInFirst)) {
                    System.out.print(elementInSecond + " ");
                }
            }
        }
    }
}
