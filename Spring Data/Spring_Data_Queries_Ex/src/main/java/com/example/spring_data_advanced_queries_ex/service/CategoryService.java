package com.example.spring_data_advanced_queries_ex.service;

import com.example.spring_data_advanced_queries_ex.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
