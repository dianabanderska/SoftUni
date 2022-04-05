import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distancePokemons = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        while (distancePokemons.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= distancePokemons.size() - 1) {
                int removedElement = distancePokemons.get(index);
                sum += removedElement;
                distancePokemons.remove(index);
                changeElements(distancePokemons, removedElement);

            } else if (index < 0) {
                int removedFirstElement = distancePokemons.get(0);
                sum += removedFirstElement;
                int lastElement = distancePokemons.get(distancePokemons.size() - 1);
                distancePokemons.set(0, lastElement);
                changeElements(distancePokemons, removedFirstElement);

            } else if (index > distancePokemons.size() - 1) {
                int removedLastElement = distancePokemons.get(distancePokemons.size() - 1);
                sum += removedLastElement;
                int firstElement = distancePokemons.get(0);
                distancePokemons.set(distancePokemons.size() - 1, firstElement);
                changeElements(distancePokemons, removedLastElement);
            }
        }
        System.out.println(sum);
    }

    private static void changeElements(List<Integer> distancePokemons, int removedFirstElement) {
        for (int i = 0; i < distancePokemons.size(); i++) {
            int currentNum = distancePokemons.get(i);

            if (currentNum <= removedFirstElement) {
                currentNum += removedFirstElement;
            } else {
                currentNum -= removedFirstElement;
            }
            distancePokemons.set(i, currentNum);
        }
    }
}
