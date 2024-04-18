package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService){
        this.carService=carService;
    }
    @GetMapping
    public List<CarDto> findAllCars(){
        return carService.findAllCars();
    }
    @PostMapping
    public CarDto registerCar(@Valid @RequestBody CarDto carDto){
        return carService.registerCar(carDto);
    }
}
