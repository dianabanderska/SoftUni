import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];

            switch (firstCommand) {
                case "swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    int element1 = nums.get(index1);
                    int element2 = nums.get(index2);
                    swap(nums, index1, index2, element1, element2);
                    break;
                case "multiply":
                    index1 = Integer.parseInt(tokens[1]);
                    index2 = Integer.parseInt(tokens[2]);
                    element1 = nums.get(index1);
                    element2 = nums.get(index2);
                    multiply(nums, index1, element1, element2);
                    break;
                case "decrease":
                    decrease(nums);
                    break;
            }
            command = scanner.nextLine();
        }

        List<String> stringList = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            stringList.add(String.valueOf(nums.get(i)));
        }

        System.out.println(String.join(", ", stringList));

    }

    private static void decrease(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int result = nums.get(i) - 1;
            nums.set(i, result);
        }
    }

    private static void swap(List<Integer> nums, int index1, int index2, int element1, int element2) {
        nums.set(index1, element2);
        nums.set(index2, element1);
    }

    private static void multiply(List<Integer> nums, int index1, int element1, int element2) {
        int result = element1 * element2;
        nums.set(index1, result);
    }
}
