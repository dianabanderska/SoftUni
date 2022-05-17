package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(10, 12);

        Integer[] integers1 = ArrayCreator.<Integer>create(10, 12);

        String[] strings = ArrayCreator.<String>create(String.class, 3, "Java");

        Integer[] integers2 = ArrayCreator.<Integer>create(Integer.class, 3, 5);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
