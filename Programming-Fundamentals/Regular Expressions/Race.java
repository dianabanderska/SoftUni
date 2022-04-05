import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racersDistance = new LinkedHashMap<>();
        racers.forEach(r -> racersDistance.put(r, 0));

        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "\\d";
        Pattern patternDigit = Pattern.compile(regexDigit);

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            StringBuilder sb = new StringBuilder();
            Matcher matcherName = patternLetter.matcher(input);

            while (matcherName.find()) {
                sb.append(matcherName.group());
            }
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }
            String racerName = sb.toString();
            if (racersDistance.containsKey(racerName)) {
                int currentDistance = racersDistance.get(racerName);
                racersDistance.put(racerName, distance + currentDistance);
            }
            input = scanner.nextLine();
        }

        List<String> firstThreeNames = racersDistance.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeNames.get(0));
        System.out.println("2nd place: " + firstThreeNames.get(1));
        System.out.println("3rd place: " + firstThreeNames.get(2));
    }
}
