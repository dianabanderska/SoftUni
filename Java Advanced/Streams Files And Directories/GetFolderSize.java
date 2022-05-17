import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String pathStr = "C:\\Users\\Diana\\Desktop\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(pathStr);

        File[] filesInFolder = folder.listFiles();

        int folderSize = 0;
        for (File file : filesInFolder) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
