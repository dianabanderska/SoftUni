import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Diana\\Desktop\\Lectures" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read(); //read first symbol in the text
        int value2 = inputStream.read();//read the next symbol in the text

        while (value != -1) {
            System.out.print((char) value);
            value = inputStream.read();
        }
    }
}
