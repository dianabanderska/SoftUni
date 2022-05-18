package FootShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Buyer buyer = null;
            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            } else if (tokens.length == 3) {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                throw new IllegalArgumentException("Wrong parameter count");
            }
            buyerList.add(buyer);
        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {
            for (Buyer person : buyerList) {
                if (name.equals(person.getName())) {
                    person.buyFood();
                    break;
                }
            }

            name = scanner.nextLine();
        }

        int totalFood = 0;
        for (Buyer buyer : buyerList) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }
}

