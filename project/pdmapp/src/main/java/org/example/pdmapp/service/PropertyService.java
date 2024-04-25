package org.example.pdmapp.service;

import org.example.pdmapp.model.Property;

import java.util.List;

public interface PropertyService {
    List<Property> listAllPropertiesByState(String state);
}
