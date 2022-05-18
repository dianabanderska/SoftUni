package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (!NameValidator.isValidName(name)) {
            String str = ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE.getMessage();
            throw new IllegalArgumentException(str);
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (!NumericValidator.isNonNegative(cost)) {
            String str = ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE.getMessage();
            throw new IllegalArgumentException(str);
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
