import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> pianoPieces = new LinkedHashMap<>();

        int initiallyPieces = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < initiallyPieces; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            List<String> infoList = new ArrayList<>();
            infoList.add(composer);
            infoList.add(key);

            pianoPieces.putIfAbsent(piece, infoList);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            switch (tokens[0]) {
                case "Add":
                    String piece = tokens[1];
                    String composer = tokens[2];
                    String key = tokens[3];
                    add(pianoPieces, piece, composer, key);
                    break;
                case "Remove":
                    String pieceToRemove = tokens[1];
                    remove(pianoPieces, pieceToRemove);
                    break;
                case "ChangeKey":
                    String pieceToChange = tokens[1];
                    String newKey = tokens[2];
                    changeKey(pianoPieces, pieceToChange, newKey);
                    break;
            }
            input = scanner.nextLine();
        }

        printPianoPieces(pianoPieces);
    }

    private static void printPianoPieces(Map<String, List<String>> pianoPieces) {
        for (Map.Entry<String, List<String>> entry : pianoPieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0),
                    entry.getValue().get(1));
        }

    }

    private static void changeKey(Map<String, List<String>> pianoPieces, String pieceToChange, String newKey) {
        if (pianoPieces.containsKey(pieceToChange)) {
            pianoPieces.get(pieceToChange).set(1, newKey);
            System.out.printf("Changed the key of %s to %s!%n", pieceToChange, newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChange);
        }
    }

    private static void remove(Map<String, List<String>> pianoPieces, String pieceToRemove) {
        if (pianoPieces.containsKey(pieceToRemove)) {
            pianoPieces.remove(pieceToRemove);
            System.out.printf("Successfully removed %s!%n", pieceToRemove);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
        }
    }

    private static void add(Map<String, List<String>> pianoPieces, String piece, String composer, String key) {
        if (pianoPieces.containsKey(piece)) {
            System.out.printf("%s is already in the collection!%n", piece);
        } else {
            pianoPieces.put(piece, new ArrayList<>());
            pianoPieces.get(piece).add(composer);
            pianoPieces.get(piece).add(key);
            System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
        }
    }
}
