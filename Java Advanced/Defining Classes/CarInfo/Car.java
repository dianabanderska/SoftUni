package CarInfo;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public Car() {
    }

    public Car(String brand) {
        this(brand, null, 0);
    }

    public Car(String brand, String model) {
        this(brand, model, 0);
    }

    public Car(String brand, int horsePower) {
        this(brand, null, horsePower);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (other instanceof Car) {
            Car second = (Car) other;
            return this.brand.equals(second.brand)
                    && this.model.equals(second.model)
                    && this.horsePower == second.horsePower;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
