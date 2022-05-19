import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean isWonBattle = true;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (energy < distance) {
                isWonBattle = false;
                break;
            } else {
                count++;
                if (count % 3 == 0) {
                    energy -= distance;
                    energy += count;
                } else {
                    energy -= distance;
                }
            }
            input = scanner.nextLine();
        }
        if (isWonBattle) {
            System.out.printf("Won battles: %d. Energy left: %d", count, energy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                    count, energy);
        }
    }
}
