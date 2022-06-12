package com.example.game_store.services.impl;

import com.example.game_store.models.dto.GameDetailsView;
import com.example.game_store.models.dto.GameTitlePriceView;
import com.example.game_store.models.dto.GameAddDto;
import com.example.game_store.models.entities.Game;
import com.example.game_store.repositories.GameRepository;
import com.example.game_store.services.GameService;
import com.example.game_store.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations =
                validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);

        System.out.println("Added game: " + gameAddDto.getTitle());
    }

    @Override
    public List<GameTitlePriceView> findAll() {

        List<Game> games = this.gameRepository.findAll();
        List<GameTitlePriceView> gameViews = new ArrayList<>();

        for (Game game : games) {
            GameTitlePriceView gameView = modelMapper.map(game, GameTitlePriceView.class);
            gameViews.add(gameView);
        }

        return gameViews;
    }

    @Override
    public GameDetailsView findGameDetails(String title) {
        Game game = this.gameRepository.findByTitle(title);
        GameDetailsView gameDetailsView = modelMapper.map(game, GameDetailsView.class);

        return gameDetailsView;
    }
}
