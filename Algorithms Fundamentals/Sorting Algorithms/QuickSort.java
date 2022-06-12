package SearchingSortingAndGreedyAlgorithms.SortingAlgorithms.AdvancedSorting;

public class QuickSort {

    //Time complexity worst case: O(n2)

    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 24, 15};

        sort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = 0; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
