package com.example.game_store.models.dto;

import java.math.BigDecimal;

public class GameTitlePriceView {

    private String title;

    private BigDecimal price;

    public GameTitlePriceView() {}

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

    @Override
    public String toString() {
        return String.format("%s %.2f%n", this.getTitle(),
                this.getPrice());
    }
}
