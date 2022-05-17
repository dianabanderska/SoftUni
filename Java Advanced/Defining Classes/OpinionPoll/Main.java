package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peoples = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String personalData = scanner.nextLine();
            String name = personalData.split("\\s+")[0];
            int age = Integer.parseInt(personalData.split("\\s+")[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                peoples.add(person);
            }
        }
        peoples.sort(Comparator.comparing(Person::getName));

        peoples.forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}