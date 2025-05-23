package eci.cvds.ecisanitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.cvds.ecisanitas.model.User;
import eci.cvds.ecisanitas.model.Appointment;
import eci.cvds.ecisanitas.repository.UserRepository;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Appointment> getUserAppointments(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getAppointments();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}