import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] userName = input.split(", ");

        for (String username : userName) {
            if (isValidUserName(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUserName(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (char symbol : username.toCharArray()) {
            if (!(symbol == '-' || symbol == '_' || Character.isLetterOrDigit(symbol))) {
                return false;
            }
        }
        return true;
    }
}
