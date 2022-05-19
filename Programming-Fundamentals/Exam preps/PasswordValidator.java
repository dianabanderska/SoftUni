import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Complete")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Make":
                    String secondCommand = tokens[1];
                    if (secondCommand.equals("Upper")) {
                        int index = Integer.parseInt(tokens[2]);
                        password = makeUpper(password, index);
                        System.out.println(password);
                    } else if (secondCommand.equals("Lower")) {
                        int indexToLower = Integer.parseInt(tokens[2]);
                        password = makeLower(password, indexToLower);
                        System.out.println(password);
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String charToInsert = tokens[2];
                    if (isInvalidIndex(password, indexToInsert)) {
                        input = scanner.nextLine();
                        continue;
                    } else {
                        password = insert(password, indexToInsert, charToInsert);
                        System.out.println(password);
                    }
                    break;
                case "Replace":
                    String charValue = tokens[1];
                    int value = Integer.parseInt(tokens[2]);
                    if (password.contains(charValue)) {
                        password = replace(password, charValue, value);
                        System.out.println(password);
                    }
                    break;
                case "Validation":
                    validation(password);
                    break;
                default:
                    input = scanner.nextLine();
                    continue;
            }
            input = scanner.nextLine();
        }
    }

    private static void validation(String newPassword) {
        if (isLenght(newPassword)) {
            System.out.println("Password must be at least 8 characters long!");
        }
        if (passwordIsNotContains(newPassword)) {
            System.out.println("Password must consist only of letters, digits and _!");
        }
        if (isHasAtLeastOneUpperCase(newPassword)) {
            System.out.println("Password must consist at least one uppercase letter!");
        }
        if (isHasAtLeastOneLowerCase(newPassword)) {
            System.out.println("Password must consist at least one lowercase letter!");
        }
        if (isHasAtLeastOneDigit(newPassword)) {
            System.out.println("Password must consist at least one digit!");
        }
    }

    private static boolean isHasAtLeastOneDigit(String password) {
        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return false;
        }
        return true;
    }

    private static boolean isHasAtLeastOneLowerCase(String password) {
        String regex = "[a-z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return false;
        }
        return true;
    }

    private static boolean isHasAtLeastOneUpperCase(String password) {
        String regex = "[A-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return false;
        }
        return true;
    }

    private static boolean passwordIsNotContains(String password) {
        String regex = "\\w";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return false;
        }
        return true;
    }
    private static boolean isLenght(String password) {
        String regex = "[A-Za-z0-9]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return false;
        }
        return true;
    }

    private static String replace(String password, String charValue, int value) {
        char charVal = charValue.charAt(0);
        int asciiValue = charVal;
        int newValue = Math.abs(asciiValue + value);
        char newChar = (char) newValue;
        String newLetter = String.valueOf(newChar);
        String oldLetter = String.valueOf(charVal);
        password = password.replace(oldLetter, newLetter);
        return password;
    }

    private static String insert(String password, int indexToInsert, String charToInsert) {
        StringBuilder sb = new StringBuilder(password);
        sb.insert(indexToInsert, charToInsert);
        return sb.toString();
    }


    private static boolean isInvalidIndex(String password, int indexToInsert) {
        return indexToInsert < 0 || indexToInsert >= password.length();
    }

    private static String makeLower(String password, int indexToLower) {
        String letterToReplace = String.valueOf(password.charAt(indexToLower));
        String newLetter = letterToReplace.toLowerCase();
        String replaced = password.replace(letterToReplace, newLetter);
        return replaced;
    }

    private static String makeUpper(String password, int index) {
        String letterToReplace = String.valueOf(password.charAt(index));
        String newLetter = letterToReplace.toUpperCase();
        String replaced = password.replace(letterToReplace, newLetter);
        return replaced;
    }
}
