package Rectangle;

public class Rectangle {
    private final int wight;
    private final int height;

    public Rectangle(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }

    public Rectangle withWight(int wight) {
        return new Rectangle(wight, this.height);
    }

    public int area() {
        return this.height * this.wight;
    }
}
