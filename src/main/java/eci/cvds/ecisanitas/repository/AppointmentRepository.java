package eci.cvds.ecisanitas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.cvds.ecisanitas.model.Appointment;


public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByStatus(String status); 
    List<Appointment> findByUserEmail(String userEmail); 
}
