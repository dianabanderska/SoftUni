import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        StringBuilder password = new StringBuilder();
        boolean isFound = false;
        int count = 0;

        for (int i = userName.length() - 1; i >= 0; i--) {
            char currentLetter = userName.charAt(i);
            password.append(currentLetter);
        }

        String passwordString = password.toString();

        for (int j = 0; j < 4; j++) {
            String tryPassword = scanner.nextLine();
            count++;
            if (passwordString.equals(tryPassword)) {
                isFound = true;
                System.out.println("User " + userName + " logged in.");
                break;
            } else if (count == 4) {
                System.out.println("User " + userName + " blocked!");
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
