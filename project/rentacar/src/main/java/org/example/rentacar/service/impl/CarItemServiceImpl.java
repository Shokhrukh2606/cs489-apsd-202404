package org.example.rentacar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.rentacar.dto.CarItemDetailDto;
import org.example.rentacar.dto.CarItemDto;
import org.example.rentacar.dto.CarItemRequestDto;
import org.example.rentacar.model.Car;
import org.example.rentacar.model.CarItem;
import org.example.rentacar.repository.CarItemRepository;
import org.example.rentacar.repository.CarRepository;
import org.example.rentacar.service.CarItemService;
import org.example.rentacar.mapper.CarItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarItemServiceImpl implements CarItemService {
    private final CarItemRepository carItemRepository;
    private final CarItemMapper carItemMapper;
    private final CarRepository carRepository;
    public CarItemServiceImpl(CarItemRepository carItemRepository, CarItemMapper carItemMapper, CarRepository carRepository){
        this.carItemRepository=carItemRepository;
        this.carItemMapper=carItemMapper;
        this.carRepository=carRepository;
    }
    @Override
    public List<CarItemDto> findAllByCarId(Long id) {
        return carItemRepository.findAllByCarId(id).stream().map(carItemMapper::toDto).toList();
    }

    @Override
    public CarItemDetailDto findCarItemByPlateNumber(String plateNumber) throws Throwable {
        CarItem carItem=carItemRepository.findCarItemByPlateNumber(plateNumber).orElseThrow(()->new EntityNotFoundException(String.format("Car Item with plate number %s not found", plateNumber)));
        return carItemMapper.toDetailDto(carItem);
    }

    @Override
    public CarItemDto registerCarItem(CarItemRequestDto carItemRequestDto) {
        Car car=carRepository.findById(carItemRequestDto.getCarId()).orElseThrow(()->new EntityNotFoundException(String.format("Car with id %d not found", carItemRequestDto.getCarId())));
        return carItemMapper.toDto(carItemRepository.save(new CarItem(null, carItemRequestDto.getPlateNumber(), carItemRequestDto.getVinNumber(),carItemRequestDto.getGarageSection(),  car)));
    }

    @Override
    public CarItemDto updateCar(Long carItemid, CarItemRequestDto carItemRequestDto) {
        CarItem carItem=carItemRepository.findById(carItemid).orElseThrow(()->new EntityNotFoundException(String.format("Car with id %d not found", carItemRequestDto.getCarId())));
        carItem.setGarageSection(carItemRequestDto.getGarageSection());
        carItem.setPlateNumber(carItemRequestDto.getPlateNumber());
        carItem.setVinNumber(carItemRequestDto.getVinNumber());
        return carItemMapper.toDto(carItemRepository.save(carItem));
    }

    @Override
    public void deleteById(Long id) {
        carItemRepository.deleteById(id);
    }
}
