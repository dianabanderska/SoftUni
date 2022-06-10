package SearchingSortingAndGreedyAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(7);
        list.add(10);
        list.add(20);
        list.add(30);

        int key = 20;
        int result = Collections.binarySearch(list, key);

        if (result >= 0) {
            System.out.println(key + " found at index = " + result);
        } else {
            System.out.println(key + " not found");
        }
    }
}
