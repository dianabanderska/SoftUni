import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courseInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] dataInput = input.split(" : ");
            String courseName = dataInput[0];
            String studentName = dataInput[1];

            if (courseInfo.containsKey(courseName)) {
                courseInfo.get(courseName).add(studentName);
            } else {
                courseInfo.put(courseName, new ArrayList<>());
                courseInfo.get(courseName).add(studentName);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseInfo.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }
    }
}
