package eci.cvds.ecisanitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eci.cvds.ecisanitas.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}