package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.mapper.CarMapper;
import org.example.rentacar.model.Car;
import org.example.rentacar.repository.CarRepository;
import org.example.rentacar.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final ObjectMapper objectMapper;
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper, ObjectMapper objectMapper){
        this.carRepository=carRepository;
        this.carMapper=carMapper;
        this.objectMapper=objectMapper;
    }
    @Override
    public List<CarDto> findAllCars() {
        return carRepository.findAll().stream().map(carMapper::toDto).toList();
    }

    @Override
    public List<CarDto> findAllCarsByCategoryId(Long id) {
        return carRepository.findAllByCategoryId(id).stream().map(carMapper::toDto).toList();
    }

    @Override
    public CarDto registerCar(CarDto carDto) {
        Car car=objectMapper.convertValue(carDto, Car.class);
        return carMapper.toDto(carRepository.save(car));
    }
}
