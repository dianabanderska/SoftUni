package com.example.game_store;

import com.example.game_store.models.dto.GameAddDto;
import com.example.game_store.models.dto.GameDetailsView;
import com.example.game_store.models.dto.UserLoginDto;
import com.example.game_store.models.dto.UserRegisterDto;
import com.example.game_store.services.GameService;
import com.example.game_store.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter your commands:");
            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]) {
                case "RegisterUser" -> userService
                        .registerUser(new UserRegisterDto(commands[1],
                                commands[2], commands[3], commands[4]));

                case "LoginUser" -> userService
                        .loginUser(new UserLoginDto(commands[1], commands[2]));

                case "Logout" -> userService.logout();

                case "AddGame" -> gameService
                        .addGame(new GameAddDto(commands[1], new BigDecimal(commands[2])
                                , Double.parseDouble(commands[3]), commands[4], commands[5],
                                commands[6], commands[7]));

                case "AllGames" -> gameService.findAll().forEach(System.out::println);

                case "DetailGame" -> printGameDetails(commands[1]);
            }
        }
    }

    private void printGameDetails(String command) {
        GameDetailsView gameDetailsView = gameService.findGameDetails(command);
        System.out.println(gameDetailsView);
    }
}
