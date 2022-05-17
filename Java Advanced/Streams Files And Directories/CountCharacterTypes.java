import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathStr));

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuations = 0;

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'o' || currentSymbol == 'e'
                        || currentSymbol == 'i' || currentSymbol == 'u') {
                    countVowels++;
                } else if (currentSymbol == '!' || currentSymbol == '.' || currentSymbol == ','
                        || currentSymbol == '?') {
                    countPunctuations++;
                } else {
                    countConsonants++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_4.txt"));
        writer.write("Vowels: " + countVowels);
        writer.newLine();
        writer.write("Consonants: " + countConsonants);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuations);

        writer.close();
    }
}

