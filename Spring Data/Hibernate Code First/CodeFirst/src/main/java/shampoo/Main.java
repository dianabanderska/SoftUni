package shampoo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shampoo", label, batch);
        BasicIngredient basicIngredient = new BasicIngredient(100, "Red");
        BasicIngredient basicIngredient2 = new BasicIngredient(200, "Violet");

        shampoo.addIngredient(basicIngredient);
        shampoo.addIngredient(basicIngredient2);

        List<String> names = Arrays.asList("John", "George", "Maria");
        shampoo.setNames(names);

        entityManager.persist(basicIngredient);
        entityManager.persist(basicIngredient2);
        entityManager.persist(batch);
        entityManager.persist(label);
        entityManager.persist(shampoo);

        ProductionBatch productionBatch = entityManager.find(ProductionBatch.class, 1);
        Set<BasicShampoo> shampoos = productionBatch.getShampoos();

        shampoos.forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

