import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([#@])(?<wordOne>[A-Za-z]{3,})\\1{2}(?<wordTwo>[A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        List<String> words = new ArrayList<>();

        int count = 0;

        while (matcher.find()) {
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            words.add(wordOne);
            words.add(wordTwo);
            count++;
        }

        List<String> mirrorWords = checkForSpellBackward(words);

        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(count + " word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }

    private static List<String> checkForSpellBackward(List<String> words) {
        List<String> mirrorWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i += 2) {
            String firstWord = words.get(i);
            String secondWord = words.get(i + 1);
            if (checkIfWordsEquals(firstWord, secondWord)) {
                mirrorWords.add(String.format("%s <=> %s", firstWord, secondWord));
            }
        }
        return mirrorWords;
    }

    private static boolean checkIfWordsEquals(String firstWord, String secondWord) {
        StringBuilder sb = new StringBuilder(secondWord);
        String word2 = sb.reverse().toString();
        if (firstWord.equals(word2)) {
            return true;
        }
        return false;
    }
}
