package com.gilasw.notification.mapper;

import com.gilasw.notification.controller.dto.CategoryDTO;
import com.gilasw.notification.domain.entities.UserCategory;

import java.util.function.Function;

public class CategoryMapper {

    public static Function<UserCategory, CategoryDTO> categoryMapper = category -> CategoryDTO.builder()
                            .categoryGuid(category.getUserCategoryGuid().toString())
                            .name(category.getCategory().getName())
                        .build();
}
