package Day;

public enum Day {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayNumber;

    Day(int dayNumber) { //tova e konstruktora i konstruiraneto se sluchva tuk v tozi klas(kudeto po gore sa dnite), a ne drugade!! ne mojem da napishem new Day naprimer!!ako se opitame da go napravim, shte imame compilacionna greshka, vsichki poleta tuk sa private(ne mojem da gi smenim na public),t.e. imame garantirano konstanten tip(ne mojem da gi promenqme ot vunshniq svqt, a samo tuk v tozi clas mojem da dobavqme stoinosti).Mojem samo da getvame.
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
