package com.example.spring_data_advanced_querying.service;

import com.example.spring_data_advanced_querying.entities.Shampoo;
import com.example.spring_data_advanced_querying.entities.Size;
import com.example.spring_data_advanced_querying.repository.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabel(Size size, Long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<String> selectInIngredientsNames(List<String> names) {
        return this.shampooRepository.findAllByIngredientsNames(names)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectByIngredientCountLessThan(int count) {
        return this.shampooRepository.findByIngredientCountLessThan(count)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }
}
