package Students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "A", 20));
        students.add(new Student(2, "B", 34));
        students.add(new Student(3, "C", 35));

        Collections.sort(students);

        students.stream().sorted(new StudentsFacNumReversedComparator())
                .forEach(System.out::println);

        students.stream()
                .sorted(new StudentComparatorByName()
                        .thenComparing(new StudentsFacNumReversedComparator()))
                .forEach(System.out::println);
    }
}
