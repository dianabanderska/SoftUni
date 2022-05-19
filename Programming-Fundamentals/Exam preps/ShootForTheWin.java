import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int count = 0;
        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            for (int i = 0; i < targets.size(); i++) {
                if (isInvalidIndex(index, targets)) {
                    continue;
                }
                if (i != index) {
                    continue;
                }
                if (targets.get(i) == -1) {
                    continue;
                }
                int shotElement = targets.get(index);
                targets.set(index, -1);
                count++;
                for (int j = 0; j < targets.size(); j++) {
                    if (targets.get(j) == -1) {
                        continue;
                    }
                    if (targets.get(j) > shotElement) {
                        int reducedElement = targets.get(j) - shotElement;
                        targets.set(j, reducedElement);
                    } else if (targets.get(j) <= shotElement) {
                        int increasedElement = targets.get(j) + shotElement;
                        targets.set(j, increasedElement);
                    }
                }
            }
            command = scanner.nextLine();
        }
        print(targets, count);
    }

    private static boolean isInvalidIndex(int index, List<Integer> targets) {
        return index < 0 || index >= targets.size();
    }

    private static void print(List<Integer> targets, int count) {
        System.out.printf("Shot targets: %d -> ", count);
        System.out.println(targets.toString().replaceAll("[\\[\\],]", ""));
    }
}

