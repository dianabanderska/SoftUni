import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());
            String command = commandLine.get(0);

            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(commandLine.get(1));

                    if (numList.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String secondCommand = commandLine.get(1);

                    if (secondCommand.equals("even")) {
                        System.out.println(joinElementsByDelimiter(getEvenNumbers(numList), " "));
                    } else {
                        System.out.println(joinElementsByDelimiter(getOddNumbers(numList), " "));
                    }
                    break;
                case "Get":
                    System.out.println(getSum(numList));
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    int numberCondition = Integer.parseInt(commandLine.get(2));
                    System.out.println(joinElementsByDelimiter(getConditionalNumbers(numList,
                            condition, numberCondition), " "));
                    break;
            }

            input = scanner.nextLine();
        }
    }

    public static List<Integer> getEvenNumbers(List<Integer> numList) {
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 == 0) {
                evenList.add(numList.get(i));
            }
        }
        return evenList;
    }

    public static List<Integer> getOddNumbers(List<Integer> numList) {
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 == 1) {
                oddList.add(numList.get(i));
            }
        }
        return oddList;
    }

    public static int getSum(List<Integer> numList) {
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }

    public static String joinElementsByDelimiter(List<Integer> numList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (Integer item : numList) {
            DecimalFormat df = new DecimalFormat("0.#");
            String numDf = df.format(item) + delimiter;
            builder.append(numDf);
        }
        return builder.toString();
    }

    public static List<Integer> getConditionalNumbers(List<Integer> numList, String condition, int number) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            int currentNum = numList.get(i);

            if (condition.equals("<")) {
                if (currentNum < number) {
                    resultList.add(currentNum);
                }
            } else if (condition.equals(">")) {
                if (currentNum > number) {
                    resultList.add(currentNum);
                }
            } else if (condition.equals("<=")) {
                if (currentNum <= number) {
                    resultList.add(currentNum);
                }
            } else if (condition.equals(">=")) {
                if (currentNum >= number) {
                    resultList.add(currentNum);
                }
            }
        }
        return resultList;
    }
}
