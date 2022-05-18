package Person;

public class Person {

    private String fullName;
    private Gender gender;
    private boolean isMarried;

    public Person(String fullName, Gender gender) {
        this.fullName = fullName;
        this.gender = gender;
        this.isMarried = false;
    }

    public void getMarried() {
        this.isMarried = true;
    }

    public void updateLastName(String lastName) {
        if (gender != Gender.FEMALE) {
            throw new IllegalStateException("Person must be " + Gender.FEMALE + " to update last name.");
        }
        if (!isMarried) {
            throw new IllegalStateException("Person must be married before update the last name.");
        }
        this.fullName += "-" + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", isMarried=" + isMarried +
                '}';
    }
}
