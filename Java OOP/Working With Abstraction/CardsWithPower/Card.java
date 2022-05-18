package CardsWithPower;

public class Card {
    private CardSuits cardSuits;
    private CardRanks cardRanks;

    public Card(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
    }

    public int getPower() {
        return this.cardSuits.getPowerSuit() + this.cardRanks.getPowerRank();
    }

    public CardSuits getCardSuits() {
        return this.cardSuits;
    }

    public CardRanks getCardRanks() {
        return this.cardRanks;
    }
}
