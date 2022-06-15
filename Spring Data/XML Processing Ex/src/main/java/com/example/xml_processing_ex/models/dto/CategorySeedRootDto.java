package com.example.xml_processing_ex.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedRootDto {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categories;

    public List<CategorySeedDto> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void setCategories(List<CategorySeedDto> categories) {
        this.categories = categories;
    }
}
