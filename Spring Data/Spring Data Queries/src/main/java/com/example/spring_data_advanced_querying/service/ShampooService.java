package com.example.spring_data_advanced_querying.service;

import com.example.spring_data_advanced_querying.entities.Shampoo;
import com.example.spring_data_advanced_querying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabel(Size size, Long labelId);

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);

    int countPriceLowerThan(BigDecimal price);

    List<String> selectInIngredientsNames(List<String> names);

    List<String> selectByIngredientCountLessThan(int count);
}
