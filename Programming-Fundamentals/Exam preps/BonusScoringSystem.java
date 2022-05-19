import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        int maxAttendances = 0;

        for (int i = 0; i < studentCount; i++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = Math.ceil(studentAttendances * 1.0 / lecturesCount * (5 + additionalBonus));
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendances = studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
