package com.example.game_store.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailsView {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameDetailsView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Title: %s", this.title)).append(System.lineSeparator());
        sb.append(String.format("Price: %s", this.price)).append(System.lineSeparator());
        sb.append(String.format("Description: %s", this.description)).append(System.lineSeparator());
        sb.append(String.format("Release date: %s", this.releaseDate));
        return sb.toString();
    }
}
