package org.example.rentacar.user;

import org.example.rentacar.controller.CarController;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.dto.CategoryDto;
import org.example.rentacar.model.Car;
import org.example.rentacar.repository.CustomerRepository;
import org.example.rentacar.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarControllerTest {
    @Mock
    private CarService carService;
    @InjectMocks
    CarController underTest;
    @Test
    void registerCar_shouldRegisterSuccessfully(){
        Car car=new Car();
        car.setId(1L);
        car.setMake("Toyota");
        CarDto carDto=new CarDto();
        carDto.setMake(car.getMake());
        carDto.setCategory(new CategoryDto());
        CarDto expected =carDto;
        Mockito.when(carService.registerCar(Mockito.any())).thenReturn(expected);
        CarDto request=new CarDto();
        request.setCategory(new CategoryDto());
        ResponseEntity<CarDto> response=underTest.registerCar(request);
        CarDto actual=response.getBody();
        assertAll(
                ()->assertNotNull(actual),
                ()->assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                ()->assertEquals(expected, actual),
                ()->assertEquals(carDto.getMake(), actual.getMake())
        );
    }

}
