package com.app.rdv.controller;

import com.app.rdv.entities.Patient;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient/")
@AllArgsConstructor
public class PatientRestController {

    private IServicePatient iServicePatient;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient){
        return iServicePatient.addPatient(patient);
    }

    @GetMapping("all")
    public List<Patient> allPatients(){
        return iServicePatient.getAllPatients();
    }
}
