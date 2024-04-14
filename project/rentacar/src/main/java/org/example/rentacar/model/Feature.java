package org.example.rentacar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Feature {
    @Column(name="feature_name")
    private String featureName;

    @Column(name = "feature_image")
    private String featureImage;
}
