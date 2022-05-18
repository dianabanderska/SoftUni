package CoffeeSize;

public enum CoffeeSize {

    Small(100),
    Normal(150),
    Double(300);

    private int size;

    CoffeeSize(int size) {
        this.size = size;
    }
    public int getValue() {
        return this.size;
    }

}
