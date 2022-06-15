package com.example.xml_processing_ex.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewRootDto {

    @XmlElement(name = "products")
    private List<ProductWithSellerViewDto> products;

    public List<ProductWithSellerViewDto> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void setProducts(List<ProductWithSellerViewDto> products) {
        this.products = products;
    }
}
