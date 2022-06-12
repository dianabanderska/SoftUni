package com.example.game_store.services;

import com.example.game_store.models.dto.GameDetailsView;
import com.example.game_store.models.dto.GameTitlePriceView;
import com.example.game_store.models.dto.GameAddDto;

import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    List<GameTitlePriceView> findAll();

    GameDetailsView findGameDetails(String title);
}
