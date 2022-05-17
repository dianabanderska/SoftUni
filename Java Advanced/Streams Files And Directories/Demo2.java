import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "C:\\Users\\Diana\\Desktop\\Lectures" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);

            int value = inputStream.read();

            while (value != -1) {
                System.out.print((char) value);
                value = inputStream.read();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Program completed");
        }
    }
}
