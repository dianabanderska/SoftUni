import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] commandParts = command.split("\\|");
            switch (commandParts[0]) {
                case "Move":
                    int indexToBack = Integer.parseInt(commandParts[1]);
                    word = move(word, indexToBack);

                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[1]);
                    String value = commandParts[2];
                    word = insert(word, index, value);
                    break;
                case "ChangeAll":
                    String letter = commandParts[1];
                    String letterToReplace = commandParts[2];
                    word = changeAll(word, letter, letterToReplace);
                    break;

            }
            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + word);
    }

    private static String changeAll(String word, String letter, String letterToReplace) {
        word = word.replace(letter, letterToReplace);
        return word;
    }

    private static String insert(String word, int index, String value) {
        StringBuilder sb = new StringBuilder();
        String first = word.substring(0, index);
        String end = word.substring(index);
        sb.append(first).append(value).append(end);
        return sb.toString();
    }

    private static String move(String word, int indexToBack) {
        StringBuilder sb = new StringBuilder();
        String firstLetters = word.substring(0, indexToBack);
        String toEnd = word.substring(indexToBack);
        sb.append(toEnd).append(firstLetters);
        return sb.toString();
    }
}
