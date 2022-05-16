import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> emailsData = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }
            name = scanner.nextLine();
        }
        emailsData.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
