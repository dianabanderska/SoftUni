import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String commandName = command.split("\\s+")[0];
            int element = Integer.parseInt(command.split("\\s+")[1]);
            if (commandName.equals("Delete")) {
                numList.removeAll(Arrays.asList(element));
            } else if (commandName.equals("Insert")) {
                int position = Integer.parseInt(command.split("\\s+")[2]);
                numList.add(position, element);
            }
            command = scanner.nextLine();
        }
        for (int number : numList) {
            System.out.print(number + " ");
        }
    }
}
