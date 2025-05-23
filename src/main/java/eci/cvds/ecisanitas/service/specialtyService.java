package eci.cvds.ecisanitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.cvds.ecisanitas.model.Specialty;
import eci.cvds.ecisanitas.repository.SpecialtyRepository;

@Service
public class specialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public Specialty getSpecialtyById(String id) {
        return specialtyRepository.findById(id).orElseThrow(() -> new RuntimeException("Specialty not found"));
    }
}