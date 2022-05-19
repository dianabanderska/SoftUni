import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String commands = scanner.nextLine();

        while (!commands.equals("Reveal")) {
            String[] commandParts = commands.split("[:|]+");

            switch (commandParts[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandParts[1]);
                    message = insertSpace(message, index);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String text = commandParts[1];
                    if (!message.contains(text)) {
                        System.out.println("error");
                        commands = scanner.nextLine();
                        continue;
                    }
                    message = reverse(message, text);
                    System.out.println(message);
                    break;
                case "ChangeAll":
                    String currentText = commandParts[1];
                    String replacement = commandParts[2];
                    if (!message.contains(currentText)) {
                        commands = scanner.nextLine();
                        continue;
                    }
                    message = changeAll(message, currentText, replacement);
                    System.out.println(message);
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }

    private static String changeAll(String message, String currentText, String replacement) {
        message = message.replaceAll(currentText, replacement);
        return message;
    }

    private static String reverse(String message, String text) {
        StringBuilder sb = new StringBuilder();
        StringBuilder reversedText = new StringBuilder();
        int firstIndex = message.indexOf(text);
        int lastIndex = firstIndex + (text.length());
        String textToDelete = message.substring(firstIndex, lastIndex);
        reversedText.append(textToDelete).reverse().toString();
        message = message.replaceFirst(textToDelete, "");
        sb.append(message).append(reversedText);

        return sb.toString();
    }

    private static String insertSpace(String message, int index) {
        StringBuilder sb = new StringBuilder();
        String first = message.substring(0, index);
        String last = message.substring(index);
        sb.append(first).append(" ").append(last);
        return sb.toString();
    }
}
