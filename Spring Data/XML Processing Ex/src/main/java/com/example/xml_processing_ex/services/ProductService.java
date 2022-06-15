package com.example.xml_processing_ex.services;

import com.example.xml_processing_ex.models.dto.ProductSeedDto;
import com.example.xml_processing_ex.models.dto.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();
}
