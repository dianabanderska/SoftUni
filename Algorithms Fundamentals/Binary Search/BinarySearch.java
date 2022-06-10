package SearchingSortingAndGreedyAlgorithms.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {0, 3, 1, 2, 5, 4};
        Arrays.sort(arr);
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println(indexOf(arr, key));
    }

    private static int indexOf(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int current = arr[mid];
            if (key < current) {
                end = mid - 1;
            } else if (key > current) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
