package org.example.appointmentmanagementapp;

import org.example.appointmentmanagementapp.model.*;
import org.example.appointmentmanagementapp.service.impl.AppointmentService;
import org.example.appointmentmanagementapp.service.impl.DentistService;
import org.example.appointmentmanagementapp.service.impl.PatientService;
import org.example.appointmentmanagementapp.service.impl.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AppointmentmanagementappApplication implements CommandLineRunner {
	public final DentistService dentistService;
	public final PatientService patientService;
	public final SurgeryService surgeryService;
	public final AppointmentService appointmentService;
	public AppointmentmanagementappApplication(DentistService dentistService, PatientService patientService, SurgeryService surgeryService, AppointmentService appointmentService){
		this.dentistService=dentistService;
		this.patientService=patientService;
		this.surgeryService=surgeryService;
		this.appointmentService=appointmentService;
	}
	public static void main(String[] args) {
		SpringApplication.run(AppointmentmanagementappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Dentist create
		Dentist dentist1=new Dentist(null, "Tony", "Smith", "+18415552626", "tony@gmail.com", LocalDate.of(1991,07,26), "Orthodontist", null);
		Dentist dentist2=new Dentist(null, "Helly", "Pearson", "+18415552627", "helly@gmail.com", LocalDate.of(1992,04,12), "Periodontist",null);
		Dentist dentist3=new Dentist(null, "Robin", "Plevin", "+18415552628", "robin@gmail.com", LocalDate.of(1993,01,11), "Prosthodontist",null);
		dentistService.registerDentist(dentist1);
		dentistService.registerDentist(dentist2);
		dentistService.registerDentist(dentist3);
//		Patient create
		Patient patient1=new Patient(null, "Gillian","White", "+18415559595", "gillian@gmail.com", LocalDate.of(1988,2,3), new Address(null, "1000 N 4th Street", "Fairfield", "Iowa",  "52556"));
		Patient patient2=new Patient(null, "Jill","Bell", "+18415551331", "jill@gmail.com", LocalDate.of(1998,2,12), new Address(null, "1000 N 2th Street", "Mount Pleasant", "Iowa",  "52556"));
		Patient patient3=new Patient(null, "Ian","MacKay", "+18415552332", "ian@gmail.com", LocalDate.of(1978,3,15), new Address(null, "1000 N 3th Street", "Ottumwa", "Iowa",  "52556"));
		Patient patient4=new Patient(null, "John","Walker", "+18415551111", "john@gmail.com", LocalDate.of(1978,4,18), new Address(null, "1000 N 5th Street", "Fairfield", "Iowa",  "52556"));
		patientService.registerPatient(patient1);
		patientService.registerPatient(patient2);
		patientService.registerPatient(patient3);
		patientService.registerPatient(patient4);
//		Surgery create
		Surgery surgery=new Surgery(null, "+18415559898", "Fairfield ADS", new Address(null, "1000 N 2th Street", "Mount Pleasant", "Iowa",  "52556"));
		surgeryService.createSurgery(surgery);
//		Appointment create
		Appointment appointment1=new Appointment(null, LocalDate.of(2024,05,1), (double) 0, null, false, dentist1, patient1, surgery);
		Appointment appointment2=new Appointment(null, LocalDate.of(2024,05,1), (double) 0, null, false, dentist2, patient2, surgery);
		Appointment appointment3=new Appointment(null, LocalDate.of(2024,05,1), (double) 0, null, false, dentist3, patient3, surgery);
		Appointment appointment4=new Appointment(null, LocalDate.of(2024,05,1), (double) 0, null, false, dentist2, patient4, surgery);
		appointmentService.createNewAppointment(appointment1);
		appointmentService.createNewAppointment(appointment2);
		appointmentService.createNewAppointment(appointment3);
		appointmentService.createNewAppointment(appointment4);
		var appointments=appointmentService.getAllAppointments();
		appointments.forEach(System.out::println);
	}
}
