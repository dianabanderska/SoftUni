import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        boolean isDead = false;
        int bestRoom = 0;

        String[] rooms = scanner.nextLine().split("[|\\s+]");

        for (int i = 0; i < rooms.length; i += 2) {
            String firstCommand = rooms[i];
            bestRoom++;
            if (firstCommand.equals("potion")) {
                int secondCommand = Integer.parseInt(rooms[i + 1]);
                int curruntHealth = health;
                health = curruntHealth + secondCommand;

                if (health > 100) {
                    health = 100;
                }
                if (health < 100) {
                    System.out.printf("You healed for %d hp.%n", secondCommand);
                    System.out.printf("Current health: %d hp.%n", health);
                }
                else {
                    System.out.printf("You healed for %d hp.%n", 100 - curruntHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                }
            } else if (firstCommand.equals("chest")) {
                int secondCommand1 = Integer.parseInt(rooms[i + 1]);
                bitcoins += secondCommand1;
                System.out.printf("You found %d bitcoins.%n", secondCommand1);
            } else {
                int secondCommand2 = Integer.parseInt(rooms[i + 1]);
                health -= secondCommand2;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", firstCommand);
                } else {
                    isDead = true;
                    System.out.printf("You died! Killed by %s.%n", firstCommand);
                    System.out.printf("Best room: %d", bestRoom);
                    break;
                }
            }
        }
        if (!isDead) {
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}