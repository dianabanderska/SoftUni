import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] input, int targetSum) {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        Set<Integer> coins = new TreeSet<>((f, s) -> Integer.compare(s, f));

        Arrays.stream(input).forEach(coins::add);

        for (Integer coin : coins) {
            int coinsToTake = targetSum / coin;

            if (coinsToTake != 0) {
                result.putIfAbsent(coin, coinsToTake);
                targetSum = targetSum % coin;
            }
            if (targetSum == 0) {
                break;
            }
        }

        return result;
    }
}
