package SearchingSortingAndGreedyAlgorithms.BinarySearch;

import java.util.Arrays;

public class BinarySearchDemo {

    int binarySearch(int[] arr, int left, int right, int x) {
        if (right >= 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, right, x);
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearchDemo bs = new BinarySearchDemo();
        int[] arr = {0, 3, 1, 5, 4, 2};
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int x = 6;
        int result = bs.binarySearch(arr, left, right, x);
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
