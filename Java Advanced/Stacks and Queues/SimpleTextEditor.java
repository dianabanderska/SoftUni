import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> wordStates = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            String commandNumber = command.split("\\s+")[0];

            switch (commandNumber) {
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    sb.append(textToAdd);
                    wordStates.push(sb.toString());
                    break;
                case "2":
                    int countElements = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = sb.length() - countElements;
                    String textToRemove = sb.substring(startIndex);
                    sb.delete(startIndex, startIndex + countElements);
                    wordStates.push(sb.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    if (wordStates.size() > 1) {
                        wordStates.pop();
                        sb = new StringBuilder(wordStates.peek());
                    } else {
                        sb = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
