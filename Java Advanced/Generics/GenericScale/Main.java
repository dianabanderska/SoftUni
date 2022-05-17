package GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> scale = new Scale<>("a", "z");
        System.out.println(scale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(45, 12);
        System.out.println(integerScale.getHeavier());
    }
}
