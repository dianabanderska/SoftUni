package Seasons;

public enum Seasons {
    SPRING(new String[]{"Mart", "April", "May"}),
    SUMMER(new String[]{"June", "July", "August"}),
    AUTUMN(new String[]{"September", "October", "November"}),
    WINTER(new String[]{"December", "January", "February"});

    private String[] months;

    Seasons(String[] months) {
        this.months = months;
    }

    public String[] getMonths() {
        return this.months;
    }
}
