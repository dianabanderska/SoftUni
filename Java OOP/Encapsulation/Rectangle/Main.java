package Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3, 3);

        System.out.println(rectangle.area());

        System.out.println(rectangle.area());
        System.out.println(rectangle.withWight(12));
        System.out.println(rectangle.area());
    }
}
