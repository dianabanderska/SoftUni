import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Path path = Path.of(pathStr);
        List<String> allLines = Files.readAllLines(path);

        //  for (String line : allLines) {
        //      int sum = 0;
        //      for (int i = 0; i < line.length(); i++) {
        //          char currentSymbol = line.charAt(i);
        //          sum += currentSymbol;
        //      }
        //      System.out.println(sum);
        //     }

        allLines.stream().map(String::toCharArray).forEach(
                charArr -> {
                    int sum = 0;
                    for (char symbol : charArr) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                }
        );
    }
}
