package org.example.appointmentmanagementapp.controller;

import org.example.appointmentmanagementapp.model.Address;
import org.example.appointmentmanagementapp.model.Patient;
import org.example.appointmentmanagementapp.service.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @MockBean
    private SurgeryService surgeryService;

    @MockBean
    private DentistService dentistService;
    @MockBean
    private AppointmentService appointmentService;
    @MockBean
    private AddressService addressService;
    @BeforeEach
    public void setUp(){
        List<Patient> patients= Arrays.asList(
            new Patient(null, "Gillian","White", "+18415559595", "gillian@gmail.com", LocalDate.of(1988,2,3), new Address(null, "1000 N 4th Street", "Fairfield", "Iowa",  "52556")),
            new Patient(null, "Jill","Bell", "+18415551331", "jill@gmail.com", LocalDate.of(1998,2,12), new Address(null, "1000 N 2th Street", "Mount Pleasant", "Iowa",  "52556")),
            new Patient(null, "Ian","MacKay", "+18415552332", "ian@gmail.com", LocalDate.of(1978,3,15), new Address(null, "1000 N 3th Street", "Ottumwa", "Iowa",  "52556")),
            new Patient(null, "John","Walker", "+18415551111", "john@gmail.com", LocalDate.of(1978,4,18), new Address(null, "1000 N 5th Street", "Fairfield", "Iowa",  "52556"))
        );
        Mockito.when(patientService.patientsList()).thenReturn(patients);
    }
    @Test
    public void testListPatients() throws Exception{
        mockMvc.perform(get("/adsweb/api/v1/patient/list"))
                .andExpect(status().isOk());
    }
}
