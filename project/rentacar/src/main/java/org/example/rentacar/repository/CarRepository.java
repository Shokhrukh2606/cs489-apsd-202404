package org.example.rentacar.repository;

import org.example.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByCategoryId(Long id);
}
