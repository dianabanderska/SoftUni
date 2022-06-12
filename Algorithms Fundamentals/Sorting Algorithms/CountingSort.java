package SearchingSortingAndGreedyAlgorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CountingSort {
    public static int[] counts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {12, 1, 5, 2, 5};

        Integer max = Collections.max(Arrays.asList(12, 1, 5, 2, 5));

        counts = new int[max + 1];

        sort(arr);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
    }
}
