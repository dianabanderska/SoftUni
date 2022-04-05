import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        java.lang.StringBuilder builder = new java.lang.StringBuilder(input);
        int strength = 0;

        for (int i = 0; i < builder.length(); i++) {
            char currentSymbol = builder.charAt(i);

            if (currentSymbol == '>') {
                strength += Integer.parseInt("" + builder.charAt(i + 1));
            } else if (currentSymbol != '>' && strength > 0) {
                builder.deleteCharAt(i);
                strength--;
                i--;
            }
        }
        System.out.println(builder);
    }
}

