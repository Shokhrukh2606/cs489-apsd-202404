package org.example.pdmapp;

import lombok.RequiredArgsConstructor;
import org.example.pdmapp.model.Lease;
import org.example.pdmapp.model.Property;
import org.example.pdmapp.repository.LeaseRepository;
import org.example.pdmapp.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class PdmappApplication implements CommandLineRunner {
    private final PropertyRepository propertyRepository;
    private final LeaseRepository leaseRepository;
    public static void main(String[] args) {

        SpringApplication.run(PdmappApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Property property1=new Property(null, "1210 Kilo Road", "Denver", "CO", 3945.50, null);
        Property property2=new Property(null, "1A Galaria", "Dallas", "TX", 950.00, null);
        propertyRepository.save(property1);
        propertyRepository.save(property2);
        Lease lease1=new Lease(null, 5121543109L, LocalDate.of(2023,9,17), LocalDate.of(2024,3,17), property1);
        Lease lease2=new Lease(null, 7000511568L, LocalDate.of(2023,10,20), LocalDate.of(2024,10,20), property1);
        Lease lease3=new Lease(null, 6927458265L, LocalDate.of(2022,12,9), LocalDate.of(2023,12,9), property2);
        leaseRepository.save(lease1);
        leaseRepository.save(lease2);
        leaseRepository.save(lease3);
        System.out.println("Created properties");
    }
}
