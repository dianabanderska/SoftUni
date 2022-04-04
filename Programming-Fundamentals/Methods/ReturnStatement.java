import java.util.Scanner;

public class ReturnStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String output = readFullName(scanner);
        System.out.println(output);
    }

    public static String readFullName(Scanner scanner) {
        StringBuilder builder = new StringBuilder();
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        builder.append(firstName)
                .append(System.lineSeparator())
                .append(lastName);

        return builder.toString();
    }
}
