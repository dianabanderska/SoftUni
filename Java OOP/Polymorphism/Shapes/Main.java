package Shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(12.00, 2.00);
        Shape shape2 = new Circle(3.00);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(shape);
        shapes.add(shape2);

        for (Shape s : shapes) {
            System.out.println(s.getArea());
            System.out.println(s.getPerimeter());
        }
    }
}
