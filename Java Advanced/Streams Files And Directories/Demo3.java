import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Diana\\Desktop\\Lectures\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
