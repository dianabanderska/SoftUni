import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        List<String> wordsList = new ArrayList<>();

        while (!words.equals("end")) {
            StringBuilder newWords = new StringBuilder();

            for (int i = words.length() - 1; i >= 0; i--) {
                char symbol = words.charAt(i);
                newWords.append(symbol);
            }
            String newWordsToString = newWords.toString();
            wordsList.add(newWordsToString);

            words = scanner.nextLine();
        }
        for (String word : wordsList) {
            System.out.println(word + " ");
        }
    }
}
