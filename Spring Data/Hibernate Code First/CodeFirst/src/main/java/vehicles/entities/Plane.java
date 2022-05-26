package vehicles.entities;

public class Plane extends Vehicle {
    private int passengerCapacity;

    public Plane() {
    }

    public Plane(String type, double price, int passengerCapacity) {
        super(type, price);
        this.passengerCapacity = passengerCapacity;
    }
}
