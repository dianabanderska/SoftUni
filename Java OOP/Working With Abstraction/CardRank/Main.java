package CardRank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        for (CardRanks suit : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}

