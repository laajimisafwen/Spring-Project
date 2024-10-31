package com.app.rdv.service;

import com.app.rdv.entities.Patient;
import com.app.rdv.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class ServicePatient implements IServicePatient{

    private final PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
