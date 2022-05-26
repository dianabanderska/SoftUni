import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        String root = "root";
        String password = scanner.nextLine();
        String dbName = "custom-orm";

        Connection connection = MyConnector.getConnection(root, password, dbName);

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        User user = new User("pesho", 25, LocalDate.now());

        userEntityManager.persist(user);

    }
}
