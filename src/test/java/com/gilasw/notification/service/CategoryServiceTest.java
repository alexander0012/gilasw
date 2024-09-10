package com.gilasw.notification.service;

import com.gilasw.notification.domain.entities.Category;
import com.gilasw.notification.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    private final String[] valuesCategory = {"Sports", "Finance", "Films"};

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSearchByNameInTheRepository() {
        var random = new Random();
        var categoryName = valuesCategory[random.nextInt(valuesCategory.length)];
        var category = createCategory(categoryName);

        when(categoryRepository.findByNameIgnoreCase(categoryName)).thenReturn(category);
        var categoryReturned = categoryService.findByNameIgnoreCaseCategory(categoryName);

        verify(categoryRepository, times(1)).findByNameIgnoreCase(categoryName);
        assertEquals(category, categoryReturned);
    }

    private Category createCategory(String category) {
        return Category.builder()
                .categoryGuid(UUID.randomUUID())
                .dateTimeCreated(now())
                .name(category)
                .build();
    }
}
