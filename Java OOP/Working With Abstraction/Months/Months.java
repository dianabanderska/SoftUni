package Months;

public enum Months {

    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"),
    JUN("June"),
    JUL("July"),
    AUG("August"),
    SEP("September"),
    OKT("October"),
    NOV("November"),
    DEK("December");

    private String month;

    Months(String month) {
        this.month = month;
    }

    public String getMonth() {
        return this.month;
    }
}

