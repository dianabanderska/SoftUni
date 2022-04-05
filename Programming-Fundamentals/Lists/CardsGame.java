import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstPlayer = firstPlayerCards.get(0);
            int secondPlayer = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstPlayer > secondPlayer) {
                firstPlayerCards.add(firstPlayer);
                firstPlayerCards.add(secondPlayer);
            } else if (secondPlayer > firstPlayer) {
                secondPlayerCards.add(secondPlayer);
                secondPlayerCards.add(firstPlayer);
            }
        }
        if (firstPlayerCards.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
        } else if (secondPlayerCards.size() == 0) {
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
        }
    }

    private static int getCardsSum(List<Integer> listCards) {
        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }
        return sum;
    }
}
