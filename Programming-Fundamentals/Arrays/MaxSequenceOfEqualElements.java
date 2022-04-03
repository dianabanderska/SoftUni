import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String max = "";

        String[] array = scanner.nextLine().split("\\s+");

        for (int i = 0; i < array.length; i++) {
            String current = "";
            current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    current += " " + array[i];
                } else {
                    break;
                }
            }
            if (current.length() > max.length()) {
                max = current;
            }
        }
        System.out.print(max);
    }
}
