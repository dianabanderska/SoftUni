import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] neighborhoods = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lastPosition = 0;

        String command = scanner.nextLine();
        while (!command.equals("Love!")) {
            String[] tokens = command.split("\\s+");
            int jumpLength = Integer.parseInt(tokens[1]);
            lastPosition += jumpLength;
            boolean invalidIndex = isInvalidIndex(neighborhoods, lastPosition);
            if (invalidIndex) {
                lastPosition = 0;
            }
            if (neighborhoods[lastPosition] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", lastPosition);
                command = scanner.nextLine();
                continue;
            } else {
                neighborhoods[lastPosition] -= 2;
            }
            if (neighborhoods[lastPosition] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", lastPosition);
            }
            command = scanner.nextLine();
        }

        int failedPlaces = failed(neighborhoods);

        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        if (failedPlaces == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", failedPlaces);
        }
    }

    private static int failed(int[] neighborhoods) {
        int count = 0;
        for (int i = 0; i < neighborhoods.length; i++) {
            if (neighborhoods[i] != 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean isInvalidIndex(int[] neighborhoods, int lastPosition) {
        return lastPosition >= neighborhoods.length;
    }
}
