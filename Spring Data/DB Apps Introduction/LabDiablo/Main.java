package LabDiablo;

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
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement statement = connection.prepareStatement(
                "SELECT user_name, first_name, last_name, COUNT(users_games.id) AS games_played FROM users" +
                        " JOIN users_games ON users_games.user_id = users.id"
                        + " WHERE user_name = ?" +
                        " GROUP BY users_games.user_id");

        String username = scanner.nextLine();

        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String dbUsername = resultSet.getString("user_name");
            String dbFirstname = resultSet.getString("first_name");
            String dbLastname = resultSet.getString("last_name");
            Integer dbGamesCount = resultSet.getInt("games_played");
            System.out.printf("User: %s\n%s %s has played %d games", dbUsername, dbFirstname,
                    dbLastname, dbGamesCount);
        } else {
            System.out.println("No such user exists");
        }
    }
}
