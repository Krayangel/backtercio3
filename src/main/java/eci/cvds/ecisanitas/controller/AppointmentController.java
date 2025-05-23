package eci.cvds.ecisanitas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eci.cvds.ecisanitas.model.Appointment;
import eci.cvds.ecisanitas.service.appointmentService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*") 
public class AppointmentController {

    @Autowired
    private appointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByStatus(status));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserEmail(@PathVariable String email) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByUserEmail(email));
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment createdAppointment = appointmentService.createAppointment(appointment);
            return ResponseEntity.ok(createdAppointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable String id) {
        try {
            appointmentService.cancelAppointment(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}