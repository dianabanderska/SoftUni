public class ArraySum {
    public static void main(String[] args) {

        int[] arr = new int[] {12, 42, 68, 73};

        int sum = sumArr(arr, 0);
        System.out.println(sum);
    }

    private static int sumArr(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumArr(arr, index + 1);
    }
}
