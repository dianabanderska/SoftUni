package com.example.xml_processing_ex.models.dto;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProductDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "product")
    @XmlElementWrapper(name = "sold-products")
    private List<ProductWithBuyerDto> products;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductWithBuyerDto> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void setProducts(List<ProductWithBuyerDto> products) {
        this.products = products;
    }
}
