import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("Yohoho!")) {

            List<String> treasure = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());

            String command = treasure.get(0);

            switch (command) {
                case "Loot":
                    add(treasure, initialLoot);
                    break;
                case "Drop":
                    int index = Integer.parseInt(treasure.get(1));
                    if (isValidIndex(index, initialLoot)) {
                        removeAndAddIndex(index, initialLoot);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(treasure.get(1));
                    if (count > initialLoot.size()) {
                        count = initialLoot.size();
                    }
                    List<String> subList = initialLoot.subList(initialLoot.size() - count, initialLoot.size());
                    subList = initialLoot.subList(initialLoot.size() - count, initialLoot.size());
                    printStolenItems(subList);
                    initialLoot = initialLoot.subList(0, initialLoot.size() - count);

                    //another way:
               //     int count = Integer.parseInt(treasure.get(1));
                //    int min = Math.min(count, treasure.size());
                //    List<String> stolenTreasure = treasure.stream()
                    //    .skip(treasure.size() - min)
                    //    .collect(Collectors.toList());
                //    treasure = treasure.stream()
                    //    .limit(treasure.size() - min)
                    //    .collect(Collectors.toList());
                //    System.out.println(String.join(", ", stolenTreasure));

            }
            line = scanner.nextLine();
        }
        getAverageGain(initialLoot);
    }

    private static void getAverageGain(List<String> initialLoot) {
        int sumLengthItem = 0;
        if (!initialLoot.isEmpty()) {
            for (String item : initialLoot) {
                sumLengthItem += item.length();
            }
            double averageGain = sumLengthItem * 1.0 / initialLoot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageGain);
        } else {
            System.out.printf("Failed treasure hunt.");
        }
    }

    private static void printStolenItems(List<String> subList) {
        System.out.println(String.join(", ", subList));
    }

    private static void removeAndAddIndex(int index, List<String> initialLoot) {
        String item = initialLoot.get(index);
        initialLoot.remove(index);
        initialLoot.add(item);
    }

    private static boolean isValidIndex(int index, List<String> initialLoot) {
        return index >= 0 && index < initialLoot.size();
    }

    private static void add(List<String> treasure, List<String> initialLoot) {
        for (int i = 1; i < treasure.size(); i++) {
            if (!initialLoot.contains(treasure.get(i))) {
                initialLoot.add(0, treasure.get(i));
            }
        }
    }
}
