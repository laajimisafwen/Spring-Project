package com.app.rdv.service;

import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv {

    private final RdvRepository rdvRepository;

    @Override
    public Rdv addRdv(Rdv rdv) {



        if (rdvRepository.findByPatientIdAndDateRdv(rdv.getPatient().getId(),  rdv.getDateRdv()) != null) {
            throw new IllegalArgumentException("Le patient a déjà un rendez-vous");
        }


        if (rdvRepository.findByMedecinIdAndDateRdv(rdv.getMedecin().getId(),  rdv.getDateRdv()) != null) {
            throw new IllegalArgumentException("Le médecin a déjà un rendez-vous ");
        }

        return rdvRepository.save(rdv);
    }

    @Override
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }
}
