package org.example.rentacar.mapper;

import org.example.rentacar.dto.CarDto;
import org.example.rentacar.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car car);
}
