package com.example.spring_data_advanced_querying.service;

import com.example.spring_data_advanced_querying.entities.Ingredient;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<Ingredient> selectNameStartsWith(String name);

    List<Ingredient> selectInNames(Collection<String> name);

    void deleteAllByName(String name);

    void updatePrice();

    void updatePrice(BigDecimal priceChange, Collection<String> names);

    List<Ingredient> findAll();
}

