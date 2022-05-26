import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

      /*  another way:
        entityManager.createQuery("UPDATE Town t SET t.name = lower(t.name) " +
                "WHERE length(t.name) >= 5");

    */
        try {
            Query from_town = entityManager.createQuery("SELECT t FROM Town t", Town.class);

            List<Town> resultList = from_town.getResultList();

            for (Town town : resultList) {
                String name = town.getName();
                if (name.length() <= 5) {
                    String toUpper = name.toUpperCase();
                    town.setName(toUpper);

                    entityManager.persist(town);
                }
            }

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
