package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.CategoryDto;
import org.example.rentacar.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
    @PostMapping
    public ResponseEntity<CategoryDto> registerCategory(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>( categoryService.registerCategory(categoryDto), HttpStatus.CREATED);
    }
}
