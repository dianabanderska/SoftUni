import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "[@#]+(?<color>[a-z]{3,})[@#]+[^A-Za-z0-9]*[\\/]+(?<amount>[0-9]+)[\\/]+";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);

        List<String> eggs = new ArrayList<>();

        while (matcher.find()) {
            String color = matcher.group("color");
            String amount = matcher.group("amount");
            eggs.add(color);
            eggs.add(amount);
        }

        for (int i = 0; i < eggs.size() - 1; i += 2) {
            System.out.printf("You found %s %s eggs!%n", eggs.get(i + 1), eggs.get(i));
        }
    }
}
