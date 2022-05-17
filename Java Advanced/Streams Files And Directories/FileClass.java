import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class FileClass {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Diana\\Desktop\\Lectures\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        // BFS:
        //   File root = path.toFile();

        //   Deque<File> queue = new ArrayDeque<>();
        //   queue.offer(root);

        //   while (!queue.isEmpty()) {
        //      File filee = queue.poll();
        //      System.out.println(file.getName());
        //      File[] filess = filee.listFiles();

        //      if (filess != null) {
        //          for (File f : filess) {
        //              if (f.isDirectory()) {
        //                   queue.offer(f);
        //               }else {
        //                  System.out.println(f.getName());
        //              }

        //              }
        //          }
        //      }

        //DFS:

        File root = path.toFile();

        dfs(root);
    }

    private static void dfs(File file) {
        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    dfs(f);
                } else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}
