package org.example.rentacar.service;

import org.example.rentacar.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> findAllCars();
    List<CarDto> findAllCarsByCategoryId(Long id);
    CarDto registerCar(CarDto carDto);
}
