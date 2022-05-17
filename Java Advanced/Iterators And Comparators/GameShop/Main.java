package GameShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameShop gameShop = new GameShop();
        List<String> games = new ArrayList<>();
        games.add("2k22");
        games.add("Super Mario");
        games.add("FIFA 2022");
        games.add("GTA V");
        games.add("Spider Man");
        games.add("Iron Man");

        gameShop.setGames(games);

        Iterator<String> shopAssistant = gameShop.iterator();

        while (shopAssistant.hasNext()) {
            System.out.println(shopAssistant.next());
        }
    }
}
