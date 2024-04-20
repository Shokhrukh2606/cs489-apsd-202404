package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createNewAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
}
