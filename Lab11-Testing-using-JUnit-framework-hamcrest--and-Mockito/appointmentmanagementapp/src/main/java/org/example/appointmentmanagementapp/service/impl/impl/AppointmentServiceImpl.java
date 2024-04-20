package org.example.appointmentmanagementapp.service.impl.impl;

import org.example.appointmentmanagementapp.model.Appointment;
import org.example.appointmentmanagementapp.repository.AppointmentRepository;
import org.example.appointmentmanagementapp.service.impl.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    public AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }


    @Override
    public Appointment createNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
