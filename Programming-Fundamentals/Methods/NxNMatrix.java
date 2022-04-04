import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            rows(n);
            System.out.println(n);
        }
    }

    public static void rows(int n) {
        for (int i = 0; i < n - 1; i++) {
            System.out.print(n + " ");
        }
    }
}
