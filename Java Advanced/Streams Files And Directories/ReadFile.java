import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Diana\\Desktop\\Lectures\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read();

        while (value != -1) {
            System.out.print(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }
    }
}
