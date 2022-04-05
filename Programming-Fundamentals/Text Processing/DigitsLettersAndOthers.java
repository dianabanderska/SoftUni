import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        java.lang.StringBuilder digits = new java.lang.StringBuilder();
        java.lang.StringBuilder letters = new java.lang.StringBuilder();
        java.lang.StringBuilder others = new java.lang.StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (Character.isDigit(symbol)) {
                digits.append(symbol);
            }else if (Character.isLetter(symbol)) {
                letters.append(symbol);
            }else {
                others.append(symbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
