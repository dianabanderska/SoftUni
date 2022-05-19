import java.util.*;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carsMap.putIfAbsent(car, new ArrayList<>());
            carsMap.get(car).add(mileage);
            carsMap.get(car).add(fuel);
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {
            String[] commandParts = commands.split(" : ");

            switch (commandParts[0]) {
                case "Drive":
                    String car = commandParts[1];
                    int distance = Integer.parseInt(commandParts[2]);
                    int fuel = Integer.parseInt(commandParts[3]);
                    drive(carsMap, car, distance, fuel);
                    break;
                case "Refuel":
                    String carToRefuel = commandParts[1];
                    int fuelToRefuel = Integer.parseInt(commandParts[2]);
                    refuel(carsMap, carToRefuel, fuelToRefuel);
                    break;
                case "Revert":
                    String carToRevert = commandParts[1];
                    int kilometersToRevert = Integer.parseInt(commandParts[2]);
                    revert(carsMap, carToRevert, kilometersToRevert);
                    break;
            }

            commands = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : carsMap.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(),
                    entry.getValue().get(0), entry.getValue().get(1));
        }

    }

    private static void revert(Map<String, List<Integer>> carsMap, String carToRevert, int kilometersToRevert) {
        int currentMileage = carsMap.get(carToRevert).get(0);
        if (currentMileage - kilometersToRevert < 10000) {
            carsMap.get(carToRevert).set(0, 10000);
        } else {
            carsMap.get(carToRevert).set(0, currentMileage - kilometersToRevert);
            System.out.printf("%s mileage decreased by %d kilometers%n", carToRevert, kilometersToRevert);
        }
    }

    private static void refuel(Map<String, List<Integer>> carsMap, String carToRefuel, int fuelToRefuel) {
        int currentFuel = carsMap.get(carToRefuel).get(1);
        if (fuelToRefuel + currentFuel > 75) {
            carsMap.get(carToRefuel).set(1, 75);
            System.out.printf("%s refueled with %d liters%n", carToRefuel, 75 - currentFuel);
        } else {
            carsMap.get(carToRefuel).set(1, fuelToRefuel + currentFuel);
            System.out.printf("%s refueled with %d liters%n", carToRefuel, fuelToRefuel);
        }
    }

    private static void drive(Map<String, List<Integer>> carsMap, String car, int distance, int fuel) {
        int currentFuel = carsMap.get(car).get(1);
        int currentMileage = carsMap.get(car).get(0);
        if (currentMileage + distance >= 100000) {
            carsMap.remove(car);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car,
                    distance, fuel);
            System.out.printf("Time to sell the %s!%n", car);
            return;
        }
        if (currentFuel < fuel) {
            System.out.println("Not enough fuel to make that ride");
        }
         else {
            carsMap.get(car).set(0, currentMileage + distance);
            carsMap.get(car).set(1, currentFuel - fuel);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car,
                    distance, fuel);
        }
    }
}
