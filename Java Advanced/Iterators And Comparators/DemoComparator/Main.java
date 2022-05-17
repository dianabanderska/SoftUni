package DemoComparator;

import DemoComparator.StringReversedComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = "I am first";
        String second = "Second is who i am";

        int result = first.compareTo(second);

        List<String> stringList = new ArrayList<>();
        stringList.add(first);
        stringList.add(second);

        stringList.sort(String::compareTo);

        for (String string : stringList) {
            System.out.println(string);
        }

        stringList.sort(new StringReversedComparator());

        for (String string : stringList) {
            System.out.println(string);
        }
    }
}
