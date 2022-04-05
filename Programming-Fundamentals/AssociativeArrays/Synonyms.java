import java.util.*;

public class Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();
        String word = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String synonym = scanner.nextLine();
            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s%n%s", entry.getKey(), String.join(" ", entry.getValue()));
        }
    }
}
