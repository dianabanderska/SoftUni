import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordsArr = scanner.nextLine().split("\\s+");

        List<String> resultList = new ArrayList();

        for (String s : wordsArr) {
            String repeat = s.repeat(s.length());
            resultList.add(repeat);
        }
        System.out.println(String.join("", resultList));
    }
}