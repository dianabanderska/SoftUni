package com.example.json_processing_ex.services;

import com.example.json_processing_ex.models.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();
}
