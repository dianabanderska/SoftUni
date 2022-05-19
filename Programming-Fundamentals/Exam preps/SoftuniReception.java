import java.util.Scanner;

public class SoftuniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeePerHour = Integer.parseInt(scanner.nextLine());
        int secondEmployeePerHour = Integer.parseInt(scanner.nextLine());
        int thirdEmployeePerHour = Integer.parseInt(scanner.nextLine());

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hours = 0;
        for (int i = studentsCount; studentsCount > 0; i--) {
            hours++;
            if (hours % 4 == 0) {
                continue;
            }
            if (studentsCount - firstEmployeePerHour <= 0 || studentsCount - secondEmployeePerHour <= 0
            ||studentsCount - thirdEmployeePerHour <= 0) {
                break;
            }
            studentsCount -= firstEmployeePerHour;
            studentsCount -= secondEmployeePerHour;
            studentsCount -= thirdEmployeePerHour;

        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
