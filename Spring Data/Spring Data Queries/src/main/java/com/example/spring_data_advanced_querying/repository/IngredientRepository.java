package com.example.spring_data_advanced_querying.repository;

import com.example.spring_data_advanced_querying.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends BaseRepository<Ingredient>{

    List<Ingredient> findAllByNameStartingWith(String name);

    List<Ingredient> findAllByNameIn(Collection<String> name);

    void deleteAllByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    @Modifying
    void updatePrice();

    @Query("UPDATE Ingredient i SET i.price = i.price * :priceChange WHERE i.name IN :names")
    @Modifying
    void updatePrice(BigDecimal priceChange, Collection<String> names);
}
