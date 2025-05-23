package eci.cvds.ecisanitas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.cvds.ecisanitas.model.Appointment;
import eci.cvds.ecisanitas.repository.AppointmentRepository;

@Service
public class appointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    public Appointment createAppointment(Appointment appointment) {
        if (appointment.getDate().before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        appointment.setStatus("Confirmed");
        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(String id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            Appointment app = appointment.get();
            app.setStatus("Cancelled");
            appointmentRepository.save(app);
        } else {
            throw new RuntimeException("Appointment not found.");
        }
    }

    

}
