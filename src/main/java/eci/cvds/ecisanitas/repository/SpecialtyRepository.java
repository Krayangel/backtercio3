package eci.cvds.ecisanitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eci.cvds.ecisanitas.model.Specialty;

public interface SpecialtyRepository extends MongoRepository<Specialty, String> {
}