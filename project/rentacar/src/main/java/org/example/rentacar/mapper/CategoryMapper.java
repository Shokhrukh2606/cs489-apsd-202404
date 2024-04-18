package org.example.rentacar.mapper;

import org.example.rentacar.dto.CategoryDto;
import org.example.rentacar.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
}
