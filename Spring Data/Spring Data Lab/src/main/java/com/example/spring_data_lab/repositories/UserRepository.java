package com.example.spring_data_lab.repositories;

import com.example.spring_data_lab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);

    boolean existsByUserName(String username);
}
