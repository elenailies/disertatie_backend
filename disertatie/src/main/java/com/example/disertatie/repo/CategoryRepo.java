package com.example.disertatie.repo;

import com.example.disertatie.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Transactional
    void deleteCategoryById(Long id);

    Optional<Category> findCategoryById(Long id);

}
