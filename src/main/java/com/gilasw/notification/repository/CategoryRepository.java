package com.gilasw.notification.repository;

import com.gilasw.notification.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByNameIgnoreCase(String name);
}
