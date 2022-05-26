import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Teo", 25);
        Student student2 = new Student("Emo", 20);
        entityManager.persist(student);
        entityManager.persist(student2);

        Student first = entityManager.find(Student.class, 1);
        entityManager.remove(first);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
