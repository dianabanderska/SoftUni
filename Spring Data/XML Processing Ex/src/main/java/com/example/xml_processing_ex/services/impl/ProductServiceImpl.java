package com.example.xml_processing_ex.services.impl;

import com.example.xml_processing_ex.models.dto.ProductSeedDto;
import com.example.xml_processing_ex.models.dto.ProductViewRootDto;
import com.example.xml_processing_ex.models.dto.ProductWithSellerViewDto;
import com.example.xml_processing_ex.models.entities.Product;
import com.example.xml_processing_ex.repositories.ProductRepository;
import com.example.xml_processing_ex.services.CategoryService;
import com.example.xml_processing_ex.services.ProductService;
import com.example.xml_processing_ex.services.UserService;
import com.example.xml_processing_ex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.getRandomUser());
                    if(product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setCategories(categoryService.getRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithoutBuyer() {
        ProductViewRootDto rootDto = new ProductViewRootDto();

        rootDto.setProducts(productRepository
                .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L),
                        BigDecimal.valueOf(1000L))
                .stream()
                .map(product -> {
                    ProductWithSellerViewDto productWithSellerViewDto =
                            modelMapper.map(product, ProductWithSellerViewDto.class);

                    productWithSellerViewDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName() == null ? ""
                                    : product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productWithSellerViewDto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
