package NeedForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void drive(double kilometers) {
        double consumedFuel = kilometers * this.fuelConsumption;
        if (this.fuel >= consumedFuel) {
            double leftFuel = this.fuel - consumedFuel;
            this.setFuel(leftFuel);
        }
    }
}
