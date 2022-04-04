import java.util.Scanner;

public class ReturnVowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        int count = getVowelsCount(text);
        System.out.println(count);
    }

    private static int getVowelsCount(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o'
                    || currentSymbol == 'u') {
                count++;
            }
        }
        return count;
    }
}


