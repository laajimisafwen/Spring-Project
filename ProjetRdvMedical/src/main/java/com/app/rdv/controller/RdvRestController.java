package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {

    private final IServiceRdv iServiceRdv;

    @PostMapping("add")
    public ResponseEntity<Rdv> add(@RequestBody Rdv rdv) {
        try {
            Rdv createdRdv = iServiceRdv.addRdv(rdv);
            return new ResponseEntity<>(createdRdv, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("all")
    public List<Rdv> allRdv() {
        return iServiceRdv.getAllRdvs();
    }
}
