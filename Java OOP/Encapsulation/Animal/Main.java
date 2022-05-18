package Animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Animal animal = new Animal(name, age);

        Cat cat = new Cat(name, age);

        System.out.println(animal.getName());
        System.out.println(animal.getAge());

        System.out.println(cat.getName());
        System.out.println(cat.getAge());
    }
}
