import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];

            switch (firstCommand) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    nums.add(number);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    if (isValidIndex(index, nums.size())) {
                        nums.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Insert":
                    int num = Integer.parseInt(tokens[1]);
                    index = Integer.parseInt(tokens[2]);
                    if (isValidIndex(index, nums.size())) {
                        nums.add(index, num);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    if (direction.equals("left")) {
                        int count = Integer.parseInt(tokens[2]);
                        shiftLeft(nums, count);
                    } else if (direction.equals("right")) {
                        int count = Integer.parseInt(tokens[2]);
                        shiftRight(nums, count);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }

    private static void shiftRight(List<Integer> nums, int count) {

        for (int i = 0; i < count; i++) {
            int lastElement = nums.get(nums.size() - 1);
            nums.add(0, lastElement);
            nums.remove(nums.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> nums, int count) {

        for (int i = 0; i < count; i++) {
            int firstElement = nums.get(0);
            nums.add(firstElement);
            nums.remove(0);
        }
    }
}
