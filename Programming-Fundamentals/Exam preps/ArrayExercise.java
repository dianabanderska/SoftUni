public class ArrayExercise {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < 7; i++) {
            System.out.println(arr[i % arr.length]);
        }

        //another way:
        int index = 0;
        for (int i = 0; i < 7; i++) {
            if (i == arr.length) {
                index = 0;
            }
            System.out.println(arr[index]);
            index++;
        }
    }
}
