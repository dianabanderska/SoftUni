import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#|])(?<itemName>[A-za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[\\d]{1,5})\\1";

        int countCalories = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> foodInfo = new ArrayList<>();
        while (matcher.find()) {

            String itemName = matcher.group("itemName");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            foodInfo.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", itemName, date, calories));

            countCalories += calories;
        }

        int countDays = countCalories / 2000;
        System.out.println("You have food to last you for: " + countDays + " days!");

        foodInfo.forEach(System.out::print);
    }
}
