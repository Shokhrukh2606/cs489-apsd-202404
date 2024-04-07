SELECT * FROM dentist as d JOIN user u on d.userId=u.id order by u.lastName asc;
select concat(u.firstName,' ',u.lastName) as patientName, u.contactPhoneNumber as patientContactNumber, u.email as patientEmail, u.dateOfBirth as patientDateOfBirth, a.date as appointmentDateTime  from appointment as a left join user u on  a.patientId=u.id where a.dentistId=1
select * from appointment as a join surgery s on a.surgeryId=s.id where s.id=1
select * from appointment as a where a.patientId=4 and date_format(date, '%Y%m%d') = date_format('2024/09/20', '%Y%m%d')