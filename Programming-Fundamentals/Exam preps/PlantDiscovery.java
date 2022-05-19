import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> rarityOfPlantsMap = new LinkedHashMap<>();
        Map<String, List<Double>> ratingOfPlantsMap = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            if (!rarityOfPlantsMap.containsKey(plant)) {
                rarityOfPlantsMap.put(plant, rarity);
            } else {
                int newRarity = rarityOfPlantsMap.get(plant) + rarity;
                rarityOfPlantsMap.put(plant, newRarity);
            }

            ratingOfPlantsMap.putIfAbsent(plant, new ArrayList<>());
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            input = input.replaceAll("[^A-z0-9\\s]", "");
            String[] tokens = input.split("\\s+");


            switch (tokens[0]) {
                case "Rate":
                    String plant = tokens[1];
                    double rating = Double.parseDouble(tokens[2]);
                    rate(ratingOfPlantsMap, plant, rating);
                    break;
                case "Update":
                    String plantToUpdate = tokens[1];
                    int newRarity = Integer.parseInt(tokens[2]);
                    update(rarityOfPlantsMap, plantToUpdate, newRarity);
                    break;
                case "Reset":
                    String plantToReset = tokens[1];
                    reset(ratingOfPlantsMap, plantToReset);
                    break;
            }

            input = scanner.nextLine();
        }

        print(rarityOfPlantsMap, ratingOfPlantsMap);
    }

    private static void print(Map<String, Integer> rarityOfPlantsMap, Map<String, List<Double>> ratingOfPlantsMap) {
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, Integer> entry : rarityOfPlantsMap.entrySet()) {
            String currentPlant = entry.getKey();
            int rating = entry.getValue();
            double average = 0.0;
            List<Double> ratingList = ratingOfPlantsMap.get(currentPlant);
            if (!ratingList.isEmpty()) {
                average = ratingList.stream().mapToDouble(v -> v).average().getAsDouble();
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", currentPlant, rating, average);
        }

    }

    private static void reset(Map<String, List<Double>> ratingOfPlantsMap, String plantToReset) {
        if (isInvalidName(ratingOfPlantsMap, plantToReset)) {
            System.out.println("error");
            return;
        }
        List<Double> ratingList = ratingOfPlantsMap.get(plantToReset);
        ratingOfPlantsMap.get(plantToReset).removeAll(ratingList);
    }

    private static void update(Map<String, Integer> rarityOfPlantsMap, String plantToUpdate, int newRarity) {
        if (isInvalidNameRaringMap(rarityOfPlantsMap, plantToUpdate)) {
            System.out.println("error");
            return;
        }
        rarityOfPlantsMap.put(plantToUpdate, newRarity);
    }

    private static void rate(Map<String, List<Double>> ratingOfPlantsMap, String plant, double rating) {
        if (isInvalidName(ratingOfPlantsMap, plant)) {
            System.out.println("error");
            return;
        } else {
            ratingOfPlantsMap.get(plant).add(rating);
        }
    }

    private static boolean isInvalidName(Map<String, List<Double>> ratingOfPlantsMap, String plant) {
        if (ratingOfPlantsMap.containsKey(plant)) {
            return false;
        }
        return true;
    }

    private static boolean isInvalidNameRaringMap(Map<String, Integer> raringOfPlantsMap, String plant) {
        if (raringOfPlantsMap.containsKey(plant)) {
            return false;
        }
        return true;
    }
}
