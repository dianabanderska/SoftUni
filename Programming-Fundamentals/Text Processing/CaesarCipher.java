import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decryptedText = scanner.nextLine();
        java.lang.StringBuilder encryptedText = new java.lang.StringBuilder();

        for (char symbol : decryptedText.toCharArray()) {
            char encryptedSymbol = (char) (symbol + 3);
            encryptedText.append(encryptedSymbol);
        }
        System.out.println(encryptedText);
    }
}

