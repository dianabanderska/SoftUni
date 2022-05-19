import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            switch (firstCommand) {
                case "Shoot":
                    int power = Integer.parseInt(tokens[2]);
                    if (isInvalidIndex(index, targets)) {
                        command = scanner.nextLine();
                        continue;
                    }
                    shootIndex(targets, index, power);
                    break;
                case "Add":
                    int value = Integer.parseInt(tokens[2]);
                    if (isInvalidIndex(index, targets)) {
                        System.out.println("Invalid placement!");
                        command = scanner.nextLine();
                        continue;
                    }
                    addIndex(targets, index, value);
                    break;
                case "Strike":
                    int radius = Integer.parseInt(tokens[2]);
                    if (isInvalidIndex(index, targets)) {
                        System.out.println("Strike missed!");
                        command = scanner.nextLine();
                        continue;
                    }
                    if (isRadiusOutOfRange(targets, index, radius)) {
                        System.out.println("Strike missed!");
                        command = scanner.nextLine();
                        continue;
                    }
                    strikeIndex(targets, index, radius);
                    break;
            }
            command = scanner.nextLine();
        }
        print(targets);
    }

    private static void print(List<Integer> targets) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < targets.size(); i++) {
            newList.add(String.valueOf(targets.get(i)));
        }
        System.out.println(String.join("|", newList));
    }

    private static void strikeIndex(List<Integer> targets, int index, int radius) {
        targets.remove(index + radius);
        targets.remove(index);
        targets.remove(index - radius);
    }

    private static boolean isRadiusOutOfRange(List<Integer> targets, int index, int radius) {
        return (index - radius) < 0 || (index - radius) >= targets.size() ||
                (index + radius) >= targets.size() || (index + radius) < 0;
    }

    private static void addIndex(List<Integer> targets, int index, int value) {
        targets.add(index, value);
    }

    private static void shootIndex(List<Integer> targets, int index, int power) {
        targets.set(index, targets.get(index) - power);
        if (targets.get(index) <= 0) {
            targets.remove(index);
        }
    }

    public static boolean isInvalidIndex(int index, List<Integer> targets) {
        return index < 0 || index >= targets.size();
    }
}
