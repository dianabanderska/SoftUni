package Comparator;

import java.util.Comparator;

public class HeroGameComparator implements Comparator<Hero> {

    @Override
    public int compare(Hero hero1, Hero hero2) {
        return hero1.getGame().compareTo(hero2.getGame());
    }
}
