import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingValidation = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] command = input.split("\\s+");
            String firstCommand = command[0];
            String userName = command[1];

            switch (firstCommand) {
                case "register":
                    String licensePlateNumber = command[2];
                    if (!parkingValidation.containsKey(userName)) {
                        parkingValidation.put(userName, licensePlateNumber);
                        System.out.println(userName + " registered " + licensePlateNumber
                                + " successfully");
                    } else {
                        System.out.println("ERROR: already registered with plate number "
                                + licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!parkingValidation.containsKey(userName)) {
                        System.out.println("ERROR: user " + userName + " is not found");
                    } else {
                        parkingValidation.remove(userName);
                        System.out.println(userName + " unregistered successfully");
                    }
                    break;
            }
        }
        parkingValidation.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
