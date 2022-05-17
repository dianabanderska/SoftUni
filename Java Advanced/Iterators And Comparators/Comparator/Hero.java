package Comparator;

public class Hero implements Comparable<Hero> {
    private String name;
    private int power;
    private String game;

    public Hero(String name, int power, String game) {
        this.name = name;
        this.power = power;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getGame() {
        return game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public int compareTo(Hero other) {
        return this.name.compareTo(other.getName());
    }
}
