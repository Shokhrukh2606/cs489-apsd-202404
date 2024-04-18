package org.example.rentacar.service;

import org.example.rentacar.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> findAllCars();
    CarDto registerCar(CarDto carDto);
}
