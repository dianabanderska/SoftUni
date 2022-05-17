package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int countPeople = 0;
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];
            Person person = new Person(name, age, town);
            people.add(person);
            countPeople++;

            input = scanner.nextLine();
        }
        
        int n = Integer.parseInt(scanner.nextLine());
        int personIndex = n - 1;

        if (personIndex < 0 || personIndex > people.size() - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Person searchedPerson = people.get(n - 1);
        people.remove(n - 1);

        int count = 0;
        for (Person person : people) {
            if (searchedPerson.compareTo(person) == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", count + 1, countPeople - (count + 1), countPeople);
        }
    }
}
