import java.io.*;

public class LineNumbers2 {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        PrintWriter writer = new PrintWriter("output-lines-reader.txt");
        BufferedReader bf = new BufferedReader(new FileReader(pathStr));

        int count = 1;
        String line = bf.readLine();
        while (line != null) {
            writer.println(count + ". " + line);
            count++;
            line = bf.readLine();
        }
    }
}
