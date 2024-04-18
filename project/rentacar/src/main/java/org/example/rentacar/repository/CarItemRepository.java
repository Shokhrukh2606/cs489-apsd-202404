package org.example.rentacar.repository;

import org.example.rentacar.model.CarItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarItemRepository extends JpaRepository<CarItem, Long> {
}
