package com.gilasw.notification.service;

import com.gilasw.notification.domain.entities.Category;
import com.gilasw.notification.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findByNameIgnoreCaseCategory(String name) {
        return categoryRepository.findByNameIgnoreCase(name);
    }
}
