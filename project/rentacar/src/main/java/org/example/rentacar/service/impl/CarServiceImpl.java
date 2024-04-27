package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.mapper.CarMapper;
import org.example.rentacar.model.Car;
import org.example.rentacar.model.Category;
import org.example.rentacar.repository.CarRepository;
import org.example.rentacar.repository.CategoryRepository;
import org.example.rentacar.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final ObjectMapper objectMapper;
    private final CategoryRepository categoryRepository;
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper, ObjectMapper objectMapper, CategoryRepository categoryRepository){
        this.carRepository=carRepository;
        this.carMapper=carMapper;
        this.objectMapper=objectMapper;
        this.categoryRepository=categoryRepository;
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

    @Override
    public CarDto registerCar(CarDto carDto, Long categoryId) {
        Car car=objectMapper.convertValue(carDto, Car.class);
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new EntityNotFoundException(String.format("Category with id %d not found!", categoryId)));
        car.setCategory(category);
        return carMapper.toDto(carRepository.save(car));
    }
}
