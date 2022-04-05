import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        java.lang.StringBuilder newText = new java.lang.StringBuilder(text);

        System.out.println(replaceRepeatingChars(newText));
    }

    private static String replaceRepeatingChars(java.lang.StringBuilder newText) {
        for (char i = 0; i < newText.length() - 1; i++) {
            char currentChar = newText.charAt(i);
            char nextChar = newText.charAt(i + 1);
            if (currentChar == nextChar) {
                newText.deleteCharAt(i);
                i--;
            }
        }
        return newText.toString();
    }
}
