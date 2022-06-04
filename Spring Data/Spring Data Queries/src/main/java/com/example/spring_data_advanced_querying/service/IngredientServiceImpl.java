package com.example.spring_data_advanced_querying.service;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import com.example.spring_data_advanced_querying.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectNameStartsWith(String name) {
        return ingredientRepository.findAllByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> selectInNames(Collection<String> name) {
        return ingredientRepository.findAllByNameIn(name);
    }

    @Override
    @Transactional
    public void deleteAllByName(String name) {
        this.ingredientRepository.deleteAllByName(name);
    }

    @Override
    @Transactional
    public void updatePrice() {
        this.ingredientRepository.updatePrice();
    }

    @Override
    @Transactional
    public void updatePrice(BigDecimal priceChange, Collection<String> names) {
        this.ingredientRepository.updatePrice(priceChange, names);
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredientRepository.findAll();
    }
}
