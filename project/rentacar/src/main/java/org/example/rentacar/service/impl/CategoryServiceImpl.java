package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rentacar.dto.CategoryDto;
import org.example.rentacar.mapper.CategoryMapper;
import org.example.rentacar.model.Category;
import org.example.rentacar.repository.CategoryRepository;
import org.example.rentacar.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private ObjectMapper objectMapper;
    public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryMapper categoryMapper,ObjectMapper objectMapper){
        this.categoryRepository=categoryRepository;
        this.categoryMapper=categoryMapper;
        this.objectMapper=objectMapper;
    }
    @Override
    public CategoryDto registerCategory(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(objectMapper.convertValue(categoryDto, Category.class)));
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }
}
