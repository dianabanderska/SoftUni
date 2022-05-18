package BirthdayCelebrations;

public class Pet implements Birthable, Creatureble {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
