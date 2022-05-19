import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shelfBooksList = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split(" \\| ");
            switch (command[0]) {
                case "Add Book":
                    String bookName = command[1];
                    if (!shelfBooksList.contains(bookName)) {
                        shelfBooksList.add(0, bookName);
                    }
                    break;
                case "Take Book":
                    String book = command[1];
                    if (shelfBooksList.contains(book)) {
                        int index = shelfBooksList.indexOf(book);
                        shelfBooksList.remove(index);
                    }
                    break;
                case "Swap Books":
                    String book1 = command[1];
                    String book2 = command[2];
                    if (shelfBooksList.contains(book1) && shelfBooksList.contains(book2)) {
                        swap(shelfBooksList, book1, book2);
                    }
                    break;
                case "Insert Book":
                    String bookToInsert = command[1];
                    if (!shelfBooksList.contains(bookToInsert)) {
                        shelfBooksList.add(bookToInsert);
                    }
                    break;
                case "Check Book":
                    int indexToCheck = Integer.parseInt(command[1]);
                    if (isValidIndex(shelfBooksList, indexToCheck)) {
                        String bookToPrint = shelfBooksList.get(indexToCheck);
                        System.out.printf("%s%n", bookToPrint);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shelfBooksList));
    }

    private static boolean isValidIndex(List<String> shelfBooksList, int indexToCheck) {
        return indexToCheck >= 0 && indexToCheck < shelfBooksList.size();
    }

    private static void swap(List<String> shelfBooksList, String book1, String book2) {
        int index1 = shelfBooksList.indexOf(book1);
        int index2 = shelfBooksList.indexOf(book2);
        shelfBooksList.set(index1, book2);
        shelfBooksList.set(index2, book1);
    }
}
