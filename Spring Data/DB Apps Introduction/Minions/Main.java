package Minions;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;

        String password = scanner.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement statement = connection.prepareStatement
                ("SELECT `name`, count(DISTINCT mv.minion_id) AS minion_count" +
                        " FROM villains AS v" +
                        " JOIN minions_villains AS mv" +
                        " ON mv.villain_id = v.id" +
                        " GROUP BY mv.villain_id" +
                        " HAVING minion_count > 15" +
                        " ORDER BY minion_count DESC;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionCount = resultSet.getInt("minion_count");

            System.out.println(villainName + " " + minionCount);
        }
    }
}
