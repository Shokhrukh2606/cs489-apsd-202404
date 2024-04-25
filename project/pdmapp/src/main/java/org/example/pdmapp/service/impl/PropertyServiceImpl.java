package org.example.pdmapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pdmapp.model.Property;
import org.example.pdmapp.repository.PropertyRepository;
import org.example.pdmapp.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public List<Property> listAllPropertiesByState(String state) {
        return propertyRepository.findAllByStateOrderByMonthlyRateAsc(state);
    }
}
