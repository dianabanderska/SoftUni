package FootShortage;

public class Rebel implements Buyer {
    private static final int INCREASE_FOOD_WITH_FIVE = 5;
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    @Override
    public void buyFood() {
        this.increaseFood(INCREASE_FOOD_WITH_FIVE);
    }

    private void increaseFood(int amount) {
        this.food += amount;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return this.group;
    }

    private void setGroup(String group) {
        this.group = group;
    }
}
