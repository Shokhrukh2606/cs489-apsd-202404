package org.example.rentacar.service;

import org.example.rentacar.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto registerCategory(CategoryDto categoryDto);
    List<CategoryDto> findAllCategories();
}
