package org.example.rentacar.repository;

import org.example.rentacar.model.CarItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarItemRepository extends JpaRepository<CarItem, Long> {
    List<CarItem> findAllByCarId(Long id);
    Optional<CarItem> findCarItemByPlateNumber(String plateNumber);
}
