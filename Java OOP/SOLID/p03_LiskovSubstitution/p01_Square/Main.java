package p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {
        printShapeArea(new Rectangle());
        printShapeArea(new Square());
    }

    public static void printShapeArea(Shape shape) {
        System.out.println(shape.getArea());
    }
}
