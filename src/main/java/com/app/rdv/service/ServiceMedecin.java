package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceMedecin implements IServiceMedecin{

    private MedecinRepository medecinRepository;
    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }
}
