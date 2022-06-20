package ru.javabegin.springboot.business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javabegin.springboot.business.entity.Category;
import ru.javabegin.springboot.business.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll (String email){
    return categoryRepository.findAll();
    }
}
