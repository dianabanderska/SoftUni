package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Hero> heroesList = new ArrayList<>();
        Hero firstHero = new Hero("Ben10", 100, "Ben10");
        Hero secondHero = new Hero("Super Mario", 99, "Super Mario");
        Hero thirdHero = new Hero("Jax", 120, "LOL");

        heroesList.add(firstHero);
        heroesList.add(secondHero);
        heroesList.add(thirdHero);

        Collections.sort(heroesList);

        HeroPowerComparator comparator = new HeroPowerComparator();
        System.out.println(comparator.compare(firstHero, secondHero));

        heroesList.sort(comparator);

        HeroGameComparator gameComparator = new HeroGameComparator();
        heroesList.sort(gameComparator);
    }
}
