package org.example.appointmentmanagementapp.advice;

import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppointmentManagementWebAPIExceptionHandler {
    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException){
        Map<String, String> errorMessagesMap=new HashMap<>();
        errorMessagesMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessagesMap;
    }
}
