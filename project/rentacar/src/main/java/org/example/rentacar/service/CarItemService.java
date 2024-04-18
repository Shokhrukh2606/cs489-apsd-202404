package org.example.rentacar.service;

import org.example.rentacar.dto.CarItemDetailDto;
import org.example.rentacar.dto.CarItemDto;
import org.example.rentacar.dto.CarItemRequestDto;

import java.util.List;

public interface CarItemService {
    List<CarItemDto> findAllByCarId(Long id);
    CarItemDetailDto findCarItemByPlateNumber(String plateNumber) throws Throwable;
    CarItemDto registerCarItem(CarItemRequestDto carItemRequestDto);
    void deleteById(Long id);
}
