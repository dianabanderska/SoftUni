import java.util.*;

public class WildZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> animals = new LinkedHashMap<>();
        Map<String, Integer> areasWithHungryAnimals = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("EndDay")) {
            String[] tokens = input.split("[ -]+");
            String command = tokens[0];

            switch (command) {
                case "Add:":
                    String animalName = tokens[1];
                    String neededFoodQuantity = tokens[2];
                    String area = tokens[3];
                    if (!animals.containsKey(animalName)) {
                        animals.put(animalName, new ArrayList<>());
                        animals.get(animalName).add(neededFoodQuantity);
                        animals.get(animalName).add(area);
                    } else {
                        int currentNeededFood = Integer.parseInt(animals.get(animalName).get(0));
                        int neededFood = Integer.parseInt(neededFoodQuantity);
                        int newNeededFood = currentNeededFood + neededFood;
                        String food = newNeededFood + "";
                        animals.get(animalName).set(0, food);
                    }
                    break;
                case "Feed:":
                    String animalNameToFood = tokens[1];
                    int food = Integer.parseInt(tokens[2]);
                    if (animals.containsKey(animalNameToFood)) {
                        int currentFood = Integer.parseInt(animals.get(animalNameToFood).get(0));
                        if (currentFood - food <= 0) {
                            animals.remove(animalNameToFood);
                            System.out.println(animalNameToFood + " was successfully fed");
                        } else {
                            int newFood = currentFood - food;
                            String newFoodToReplace = newFood + "";
                            animals.get(animalNameToFood).set(0, newFoodToReplace);
                            String areaOfHungryAnimal = animals.get(animalNameToFood).get(1);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : animals.entrySet()) {
            String animalName = entry.getKey();
            String areaOfHungryAnimal = animals.get(animalName).get(1);
            if (areasWithHungryAnimals.containsKey(areaOfHungryAnimal)) {
                int number = areasWithHungryAnimals.get(areaOfHungryAnimal);
                areasWithHungryAnimals.put(areaOfHungryAnimal, number + 1);
            } else {
                areasWithHungryAnimals.put(areaOfHungryAnimal, 1);
            }
        }


        System.out.println("Animals:");

        for (Map.Entry<String, List<String>> entry : animals.entrySet()) {
            System.out.printf("%s -> %sg%n", entry.getKey(), entry.getValue().get(0));
        }
        System.out.println("Areas with hungry animals:");

        for (Map.Entry<String, Integer> entry : areasWithHungryAnimals.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
