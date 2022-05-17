import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path pathToWords = Path.of("C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        List<String> allLinesWords = Files.readAllLines(pathToWords);

        allLinesWords.forEach(line -> Arrays.stream(line.split("\\s+"))
                .forEach(word -> wordCounts.put(word, 0)));

        Path pathText = Path.of("C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> textAllLines = Files.readAllLines(pathText);

        for (String line : textAllLines) {
            String[] wordsInLine = line.split("\\s+");
            Arrays.stream(wordsInLine).forEach(word -> {
                if (word.contains(",")) {
                    word = word.replaceAll(",", "");
                }
                if (wordCounts.containsKey(word)) {
                    int currentCount = wordCounts.get(word);
                    wordCounts.put(word, currentCount + 1);
                }
            });

            Stream<Map.Entry<String, Integer>> sorted = wordCounts.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            PrintWriter writer = new PrintWriter("countWords.txt");

            wordCounts.forEach((key, value) -> writer.println(key + " - " + value));

            writer.close();
        }
    }
}
