import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([=\\/])(?<destination>[A-Z][A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        List<String> destinationList = new ArrayList<>();

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinationList.add(destination);
        }
        int travelPoints = calculateTravelPoints(destinationList);

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationList));
        System.out.println("Travel Points: " + travelPoints);
    }

    private static int calculateTravelPoints(List<String> destinationList) {
        int points = 0;
        for (int i = 0; i < destinationList.size(); i++) {
            String destination = destinationList.get(i);
            for (int j = 0; j < destination.length(); j++) {
                points++;
            }
        }
        return points;
    }
}
