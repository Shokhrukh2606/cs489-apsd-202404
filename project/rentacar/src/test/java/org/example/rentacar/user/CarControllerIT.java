package org.example.rentacar.user;

import org.example.rentacar.RentacarApplication;
import org.example.rentacar.dto.CarDto;
import org.example.rentacar.dto.CategoryDto;
import org.example.rentacar.dto.FeatureDto;
import org.example.rentacar.dto.FuelEfficiencyDto;
import org.example.rentacar.model.Car;
import org.example.rentacar.model.Category;
import org.example.rentacar.model.Feature;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.HttpHeaders;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;


@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = "org.example.rentacar")
@SpringBootTest(classes = RentacarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerIT {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate=new TestRestTemplate();
    HttpHeaders headers=new HttpHeaders();
    @Test
    public void testRegisterCar() throws JSONException{
        Set<FeatureDto> featureSet=new HashSet<FeatureDto>();
        FeatureDto featureDto=new FeatureDto();
        featureDto.setFeatureImage("/feature.png");
        featureDto.setFeatureName("Cruise Control");
        featureSet.add(featureDto);
        FuelEfficiencyDto fuelEfficiencyDto=new FuelEfficiencyDto(18,22,20);
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setName("SUVs");
        CarDto car=new CarDto(
                "Toyota",
                "Corolla",
                2009,
                4,
                3,
                "/photo.png",
                "A11",
                featureSet,
                12.0,
                fuelEfficiencyDto,
                categoryDto
        );
        HttpEntity<CarDto> entity=new HttpEntity<>(car, headers);
        ResponseEntity<CategoryDto> response=restTemplate.exchange(
                createURLWithPort("/api/cars"),
                HttpMethod.GET, entity, CategoryDto.class
        );
        CategoryDto actual=response.getBody();
        System.out.println(actual.toString());
        assertEquals(categoryDto, actual);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
