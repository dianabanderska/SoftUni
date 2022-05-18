package CodingTracker;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Tracker.printMethodByAuthor(Reflection.class);
        Class<Reflection> clazz = Reflection.class;

        Map<String, String> dataMap = new HashMap<>();

        if (clazz.getDeclaredAnnotation(Author.class) != null) {
            dataMap.put(clazz.getDeclaredAnnotation(Author.class).name(), "1");
        }
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
            System.out.println();
        }
    }
}
