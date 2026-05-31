package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{

// List ko hata ke categoryRepository daal rahe h jo autowired se khud le lega
//    private List<Category> categories = new ArrayList<>();

//    remove this because its not need latter I will use auto generation
//    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        // ye list optional ko hata ke categoryRepository user kar rahe h

//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Resourse not found"));
//
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully !!";

    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        // ye local verial ko dismis kar diye taki categoryRepository use kar sake

//        ye niche wala local variable h
//        List<Category> categories = categoryRepository.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if(optionalCategory.isPresent()){
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category saveCategory = categoryRepository.save(existingCategory);
//            return saveCategory;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found");
//        }

//    categoryRepository ka use kar rahe taki code optimal ho
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }
}
