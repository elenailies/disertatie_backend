package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Category;
import com.example.disertatie.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category){
        //category.setName(UUID.randomUUID().toString());
        return categoryRepo.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    public Category findCategoryById(Long id){
        return categoryRepo.findCategoryById(id)
                .orElseThrow(() -> new UserNotFoundException("Category by id " + id + " was not found"));
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteCategoryById(id);

    }

}
