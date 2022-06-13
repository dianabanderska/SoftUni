package com.example.json_processing_ex.models.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Integer age;

    @ManyToMany
    private Set<User> friends;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private Set<Product> soldProducts;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Product> getSoldProducts() {
        return Collections.unmodifiableSet(soldProducts);
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
