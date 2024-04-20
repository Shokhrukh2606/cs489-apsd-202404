package org.example.appointmentmanagementapp;

import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AbstractAppointmentmanagementappComponentTest {
    protected Logger logger= LoggerFactory.getLogger(this.getClass());
}
