package org.example.appointmentmanagementapp.service.impl;

import jakarta.transaction.Transactional;
import org.example.appointmentmanagementapp.AbstractAppointmentmanagementappComponentTest;
import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.example.appointmentmanagementapp.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class PatientServiceImplTest extends AbstractAppointmentmanagementappComponentTest {
    @Autowired
    private PatientService patientService;
    @BeforeEach
    public void setUp() {
        logger.info("PatientServiceImplTest started");
    }

    @AfterEach
    public void tearDown() {
        logger.info("PatientServiceImplTest completed");
    }
    @Test
    public void testfindPatientByIdForExistentData() throws PatientNotFoundException {
        Long patientId=1L;
        Patient patient=patientService.getPatientById(patientId);
        Assertions.assertNotNull(patient,"Failure: expected patient to be not null");
        Assertions.assertEquals(patientId, patient.getId(),"Failure: expected patientId to match");
    }
    @Test
    public void testfindPatientByIdForInvalid() throws PatientNotFoundException {
        Long patientId=10L;
        Patient patient=patientService.getPatientById(patientId);
        Assertions.assertNull(patient,"Failure: expected patient to be not null");
        Assertions.assertNotEquals(patientId, patient.getId(),"Failure: expected patientId to match");
    }
}
