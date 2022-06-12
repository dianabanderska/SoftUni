package SearchingSortingAndGreedyAlgorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffling {
    public static void main(String[] args) {

        int[] arr = {15, 24, 12, 11, 59};

        Arrays.sort(arr);

        getAsRand(arr);

        for (int rand : arr) {
            System.out.println(rand);
        }
    }

    private static void getAsRand(int[] arr) {

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, threadLocalRandom.nextInt(arr.length));
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}