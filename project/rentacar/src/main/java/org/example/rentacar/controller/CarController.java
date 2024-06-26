package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<List<CarDto>> findAllCarsByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(carService.findAllCarsByCategoryId(categoryId));
    }
    @GetMapping
    public ResponseEntity<List<CarDto>> findAllCars(){
        return ResponseEntity.ok(carService.findAllCars());
    }
    @PostMapping
    public ResponseEntity<CarDto> registerCar(@Valid @RequestBody CarDto carDto){
        if(carDto.getCategory().getId()!=null){
            return new ResponseEntity<>(carService.registerCar(carDto, carDto.getCategory().getId()), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(carService.registerCar(carDto), HttpStatus.CREATED);
    }
}
