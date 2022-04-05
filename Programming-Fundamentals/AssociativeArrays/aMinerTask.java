import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourceMap.containsKey(command)) {
                resourceMap.put(command, quantity);
            } else {
                int currentValue = resourceMap.get(command);
                resourceMap.put(command, currentValue + quantity);
            }
            command = scanner.nextLine();
        }
        resourceMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
