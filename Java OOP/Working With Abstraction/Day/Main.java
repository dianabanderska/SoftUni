package Day;

public class Main {
    public static void main(String[] args) {

        System.out.println((Day.MONDAY.getDayNumber()));

        Day[] values = Day.values();

        for (Day value : values) {
            System.out.println(value.getDayNumber());
        }

        String text = "MONDAY";
        Day day = Day.valueOf(text);
        System.out.println(day);
    }
}
