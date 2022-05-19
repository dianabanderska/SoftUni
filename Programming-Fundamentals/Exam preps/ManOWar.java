import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (isValidIndex(index, warShip)) {
                        int getIndexToAttack = warShip.get(index);
                        getIndexToAttack -= damage;
                        if (getIndexToAttack <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                        warShip.set(index, getIndexToAttack);
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int pirateDamage = Integer.parseInt(tokens[3]);
                    if (isValidIndexes(startIndex, endIndex, pirateShip)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int health = pirateShip.get(i);
                            health -= pirateDamage;
                            pirateShip.set(i, health);

                            if (health <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt(tokens[1]);
                    int givenHealth = Integer.parseInt(tokens[2]);
                    if (isValidIndex(indexToRepair, pirateShip)) {
                        int health = pirateShip.get(indexToRepair);
                        repair(pirateShip, indexToRepair, givenHealth, maxHealth);
                    }
                    break;
                case "Status":
                    printStatus(pirateShip, maxHealth);
                    break;
            }
            input = scanner.nextLine();
        }

        int pirateShipSum = 0;
        for (Integer e : pirateShip) {
            pirateShipSum += e;
        }
        int warShipSum = 0;
        for (Integer e : warShip) {
            warShipSum += e;
        }
        System.out.printf("Pirate ship status: %d%n", pirateShipSum);
        System.out.printf("Warship status: %d", warShipSum);
    }

    private static void printStatus(List<Integer> pirateShip, int maxHealth) {
        double percentMaxHealthCapacity = maxHealth * 0.20;
        int count = 0;
        for (Integer e : pirateShip) {
            if (e < percentMaxHealthCapacity) {
                count++;
            }
        }
        System.out.printf("%d sections need repair.%n", count);
    }

    private static void repair(List<Integer> pirateShip, int indexToRepair, int givenHealth, int maxHealth) {
        int health = pirateShip.get(indexToRepair);
        health += givenHealth;
        pirateShip.set(indexToRepair, health);
        if (health > maxHealth) {
            pirateShip.set(indexToRepair, maxHealth);
        }
    }

    private static boolean isValidIndexes(int startIndex, int endIndex, List<Integer> pirateShip) {
        return (startIndex >= 0 && startIndex < pirateShip.size()) &&
                (endIndex >= 0 && endIndex < pirateShip.size()) && startIndex < endIndex;
    }

    private static boolean isValidIndex(int index, List<Integer> ship) {
        return index >= 0 && index < ship.size();
    }
}
