import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantityKg = Double.parseDouble(scanner.nextLine());
        double hayQuantityKg = Double.parseDouble(scanner.nextLine());
        double coverQuantityKg = Double.parseDouble(scanner.nextLine());
        double guineaWeightKg = Double.parseDouble(scanner.nextLine());

        double foodGrams = foodQuantityKg * 1000;
        double hayGrams = hayQuantityKg * 1000;
        double coverGrams = coverQuantityKg * 1000;
        double weightGrams = guineaWeightKg * 1000;

        boolean isQuantityEnded = false;

        int count = 0;

        for (int i = 0; i < 30; i++) {
            count++;
            foodGrams -= 300;

            if (count % 2 == 0) {
                double hayToGive = foodGrams * 0.05;
                hayGrams -= hayToGive;
            }
            if (count % 3 == 0) {
                double coverToGive = weightGrams / 3;
                coverGrams -= coverToGive;
            }
            if (foodGrams <= 0 || hayGrams <= 0 || coverGrams <= 0) {
                System.out.println("Merry must go to the pet store!");
                isQuantityEnded = true;
                break;
            }
        }
        if (count == 30 && !isQuantityEnded) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodGrams / 1000, hayGrams / 1000, coverGrams / 1000);
        }
    }
}
