package com.example.spring_data_advanced_querying.repository;

import com.example.spring_data_advanced_querying.entities.Shampoo;
import com.example.spring_data_advanced_querying.entities.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooRepository extends BaseRepository<Shampoo>{

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsNames(@Param("names")List<String> names);

    @Query("SELECT s FROM Shampoo s" +
            " WHERE s.ingredients.size < :ingredientCount")
    List<Shampoo> findByIngredientCountLessThan(int ingredientCount);
 }