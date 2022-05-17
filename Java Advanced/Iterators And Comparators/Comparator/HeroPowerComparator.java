package Comparator;

import java.util.Comparator;

public class HeroPowerComparator implements Comparator<Hero> {

    @Override
    public int compare(Hero hero1, Hero hero2) {
        return Integer.compare(hero1.getPower(), hero2.getPower());
    }
}
