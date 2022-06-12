package SearchingSortingAndGreedyAlgorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsShuffle {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        System.out.println("List before shuffle: " + String.join(" ", list));

        Collections.shuffle(list);

        System.out.println("List after shuffle: " + String.join(" ", list));
    }
}
