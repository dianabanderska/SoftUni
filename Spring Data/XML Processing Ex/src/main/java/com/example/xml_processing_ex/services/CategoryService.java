package com.example.xml_processing_ex.services;

import com.example.xml_processing_ex.models.dto.CategorySeedDto;
import com.example.xml_processing_ex.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();

    Set<Category> getRandomCategories();
}
