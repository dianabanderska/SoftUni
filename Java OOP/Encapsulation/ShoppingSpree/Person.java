package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!NameValidator.isValidName(name)) {
            String str = ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE.getMessage();
            throw new IllegalArgumentException(str);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (!NumericValidator.isNonNegative(money)) {
            String str = ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE.getMessage();
            throw new IllegalArgumentException(str);
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            String message = String.format("%s can't afford %s", this.name, product.getName());
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public String toString() {
        String productsOutput = this.products.isEmpty() ? "Nothing bought"
                : this.products.stream().map(Product::getName)
                .collect(Collectors.joining(", "));

        return this.name + " - " + productsOutput;
    }
}
