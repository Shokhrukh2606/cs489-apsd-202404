package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.CarItemDetailDto;
import org.example.rentacar.dto.CarItemDto;
import org.example.rentacar.dto.CarItemRequestDto;
import org.example.rentacar.service.CarItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/caritems")
public class CarItemController {
    private final CarItemService carItemService;
    public CarItemController(CarItemService carItemService){
        this.carItemService=carItemService;
    }
    @GetMapping("/{carId}")
    public ResponseEntity<List<CarItemDto>> findAllByCarId(@PathVariable Long carId){
        return ResponseEntity.ok(carItemService.findAllByCarId(carId));
    }

    @GetMapping("/plate/{plateNumber}")
    public ResponseEntity<CarItemDetailDto> findCarByPlate(@PathVariable String plateNumber) throws Throwable {
        return ResponseEntity.ok(carItemService.findCarItemByPlateNumber(plateNumber));
    }
    @PostMapping
    public ResponseEntity<CarItemDto> registerCarItem(@Valid @RequestBody CarItemRequestDto carItemRequestDto){
        return new ResponseEntity<>(carItemService.registerCarItem(carItemRequestDto), HttpStatus.CREATED);
    }
    @PutMapping("/{carItemId}")
    public ResponseEntity<CarItemDto> updateCarItem(@PathVariable Long carItemId, @Valid @RequestBody CarItemRequestDto carItemRequestDto){
        return new ResponseEntity<>(carItemService.updateCar(carItemId,carItemRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarItem(@PathVariable Long id){
        carItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
