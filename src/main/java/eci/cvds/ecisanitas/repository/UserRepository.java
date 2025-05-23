package eci.cvds.ecisanitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eci.cvds.ecisanitas.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}