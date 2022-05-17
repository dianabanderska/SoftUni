import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Diana\\Desktop\\Lectures\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("out-as-bytes.txt");

        PrintStream out = new PrintStream(outputStream);

        int value = inputStream.read();
        while (value != -1) {
            if (value != 32 && value != 10) {
                out.print(value);
            } else {
                out.print((char) value);
            }

            value = inputStream.read();
        }
    }
}
