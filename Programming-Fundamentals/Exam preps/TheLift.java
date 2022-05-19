import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < lift.length; i++) {

            for (int j = lift[i]; j <= 4; j++) {
                if (lift[i] < 4 && people > 0) {
                    lift[i]++;
                    people--;
                    if (lift[i] == 4) {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < lift.length; i++) {

            if (people == 0 && lift[i] < 4) {
                System.out.println("The lift has empty spots!");
                printArr(lift);
                return;
            }
            else if (people > 0 && lift[lift.length - 1] == 4) {
                System.out.printf("There isn't enough space! %d people in a queue!\n", people);
                printArr(lift);
                return;
            } else if (people == 0 && lift[lift.length - 1] == 4) {
               printArr(lift);
                return;
            }
        }
    }
    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}




