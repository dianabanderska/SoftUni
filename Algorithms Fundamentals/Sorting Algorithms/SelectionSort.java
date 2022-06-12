package SearchingSortingAndGreedyAlgorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    //time complexity:
    //worst: O(n^2)
    //memory O(1)

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        selectionSort(arr);

        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}
