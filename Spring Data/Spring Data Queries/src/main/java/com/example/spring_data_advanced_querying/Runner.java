package com.example.spring_data_advanced_querying;

import com.example.spring_data_advanced_querying.entities.Size;
import com.example.spring_data_advanced_querying.service.IngredientService;
import com.example.spring_data_advanced_querying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task 1:");
        System.out.println("Enter size (MEDIUM, SMALL, LARGE): ");
        Size size = Size.valueOf(scanner.nextLine());

        this.shampooService.selectBySize(size)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 2:");
        System.out.println("Enter size (MEDIUM, SMALL, LARGE): ");
        size = Size.valueOf(scanner.nextLine());
        long labelId = Long.parseLong(scanner.nextLine());

        this.shampooService.selectBySizeOrLabel(size, labelId)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 3:");
        System.out.println("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        this.shampooService.selectMoreExpensiveThan(price)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 4:");
        System.out.println("Enter name: ");
        String nameStartsWith = scanner.nextLine();

        this.ingredientService.selectNameStartsWith(nameStartsWith)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 5:");
        System.out.println("Enter names: ");
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        this.ingredientService.selectInNames(names)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 6:");
        System.out.println("Enter price ");
        BigDecimal givenPrice = new BigDecimal(scanner.nextLine());

        System.out.println(this.shampooService.countPriceLowerThan(givenPrice));

        System.out.println();
        System.out.println("JPQL");
        System.out.println();
        System.out.println("Task 7:");
        System.out.println("Enter names: ");
        List<String> ingredientNames = Arrays.asList(scanner.nextLine().split("\\s+"));

        this.shampooService.selectInIngredientsNames(ingredientNames)
                .forEach(System.out::println);


        System.out.println();
        System.out.println("Task 8:");
        System.out.println("Enter count: ");
        int count = Integer.parseInt(scanner.nextLine());

        this.shampooService.selectByIngredientCountLessThan(count)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 9:");
        System.out.println("Enter name: ");
        String nameForDelete = scanner.nextLine();

        this.ingredientService.deleteAllByName(nameForDelete);
        System.out.println("SUCCESS");

        System.out.println();
        System.out.println("Task 10:");
        this.ingredientService.findAll().forEach(i -> System.out.println(i.getPrice()));
        this.ingredientService.updatePrice();
        System.out.println("SUCCESS");
        this.ingredientService.findAll().forEach(i -> System.out.println(i.getPrice()));

        System.out.println();
        System.out.println("Task 11:");
        System.out.println("Enter price: ");
        BigDecimal priceFactor = new BigDecimal(scanner.nextLine());
        System.out.println("Enter names: ");
        List<String> namesForUpdate = Arrays.asList(scanner.nextLine().split("\\s+"));

        this.ingredientService
                .updatePrice(priceFactor, namesForUpdate);
        System.out.println("SUCCESS");
    }
}
