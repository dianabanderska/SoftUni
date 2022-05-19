import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawPassword = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    rawPassword = takeOdd(rawPassword);
                    System.out.println(rawPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    rawPassword = cutLetters(rawPassword, index, length);
                    System.out.println(rawPassword);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (rawPassword.contains(substring)) {
                        rawPassword = substituteSubstring(rawPassword, substring, substitute);
                        System.out.println(rawPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + rawPassword);
    }

    private static String substituteSubstring(String rawPassword, String substring, String substitute) {
        rawPassword = rawPassword.replaceAll(substring, substitute);
        return rawPassword;
    }

    private static String cutLetters(String rawPassword, int index, int length) {
        StringBuilder sb = new StringBuilder(rawPassword);
        sb.delete(index, length + index);

        return sb.toString();
    }

    private static String takeOdd(String rawPassword) {
        StringBuilder sb = new StringBuilder();
        for (char i = 0; i < rawPassword.length(); i++) {
            if (i % 2 != 0) {
                sb.append(rawPassword.charAt(i));
            }
        }
        return sb.toString();
    }
}
