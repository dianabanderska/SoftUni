import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String line = scanner.nextLine();

        while (!line.equals("Travel")) {
            String[] commandParts = line.split(":");

            switch (commandParts[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commandParts[1]);
                    String text = commandParts[2];
                    if (isInvalidIndex(input, index)) {
                        line = scanner.nextLine();
                        System.out.println(input);
                        continue;
                    } else {
                        input = insert(input, index, text);
                        System.out.println(input);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (isInvalidIndices(input, startIndex, endIndex)) {
                        line = scanner.nextLine();
                        System.out.println(input);
                        continue;
                    } else {
                        input = remove(input, startIndex, endIndex);
                        System.out.println(input);
                    }
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    if (!input.contains(oldString)) {
                        line = scanner.nextLine();
                        System.out.println(input);
                        continue;
                    } else {
                        input = switchStrings(input, oldString, newString);
                        System.out.println(input);
                    }
                    break;
            }

            line = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + input);
    }

    private static String switchStrings(String input, String oldString, String newString) {
        return input.replaceFirst(oldString, newString);
    }

    private static String remove(String input, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        String first = input.substring(0, startIndex);
        String last = input.substring(endIndex + 1);
        sb.append(first).append(last);
        return sb.toString();
    }

    private static boolean isInvalidIndices(String input, int startIndex, int endIndex) {
        return startIndex < 0 || startIndex >= input.length() || endIndex < 0 || endIndex >= input.length();
    }

    private static String insert(String input, int index, String text) {
        StringBuilder sb = new StringBuilder();
        String first = input.substring(0, index);
        String last = input.substring(index);
        sb.append(first).append(text).append(last);
        return sb.toString();
    }

    private static boolean isInvalidIndex(String input, int index) {
        return index < 0 || index >= input.length();
    }
}
