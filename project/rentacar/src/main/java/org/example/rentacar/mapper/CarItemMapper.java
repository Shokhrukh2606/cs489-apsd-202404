package org.example.rentacar.mapper;

import org.example.rentacar.dto.CarItemDetailDto;
import org.example.rentacar.dto.CarItemDto;
import org.example.rentacar.model.CarItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarItemMapper {
    CarItemDto toDto(CarItem carItem);
    CarItemDetailDto toDetailDto(CarItem carItem);
}
