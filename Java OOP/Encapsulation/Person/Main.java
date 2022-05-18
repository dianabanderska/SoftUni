package Person;

public class Main {
    public static void main(String[] args) {

        Person bride = new Person("Mimi Georgieva", Gender.FEMALE);

        bride.getMarried();
        bride.updateLastName("Ilieva");

        System.out.println(bride);
    }
}
