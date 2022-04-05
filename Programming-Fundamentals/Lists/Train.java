import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int allowedPassengers = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandLine = input.split("\\s+");
            String firstCommand = commandLine[0];

            if (firstCommand.equals("Add")) {
                int second = Integer.parseInt(commandLine[1]);
                wagons.add(second);
            } else {
                int passengers = Integer.parseInt(firstCommand);
                addNumber(wagons, passengers, allowedPassengers);
            }
            input = scanner.nextLine();
        }

        for (int num : wagons) {
            System.out.print(num + " ");
        }
    }

    public static void addNumber(List<Integer> wagons, int number, int allowedPassengers) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < wagons.size(); i++) {
            int currentWagon = wagons.get(i);
            if (currentWagon + number <= allowedPassengers) {
                sum += number;

                result = wagons.get(i) + sum;
                wagons.set(i, result);
                break;
            }
        }
    }
}
