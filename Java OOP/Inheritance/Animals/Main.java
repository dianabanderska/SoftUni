package Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int age = Integer.parseInt(scanner.nextLine());
        String gender = scanner.nextLine();
        Cat cat = new Cat(name, age, gender);
        cat.produceSound();
    }
}
