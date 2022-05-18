package HotelReservation;

public class PriceCalculator {
    private double pricePerDays;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDays, int days, Season season, Discount discount) {
        this.pricePerDays = pricePerDays;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }
    public double calculatePrice() {
        return (pricePerDays * season.getMultiplier()) * days * (1 - discount.getPercentage());
    }
}
