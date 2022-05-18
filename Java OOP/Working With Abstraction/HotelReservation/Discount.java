package HotelReservation;

public enum Discount {
    VIP(0.20),
    SECOND_VISIT(0.10),
    NONE(0);

    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public static Discount parseDiscount(String token) {
        switch (token) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown discount type " + token);
        }
    }
}
