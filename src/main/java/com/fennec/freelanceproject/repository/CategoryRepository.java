package com.fennec.freelanceproject.repository;

import com.fennec.freelanceproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
