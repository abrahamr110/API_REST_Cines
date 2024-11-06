package com.es.controller;

import com.es.dto.SesionDTO;
import com.es.service.SesionService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/sesiones")
public class SesionController {
    private final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @GetMapping("/")
    public ResponseEntity<SesionDTO> getAll() {
        return ResponseEntity.ok(sesionService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<SesionDTO> getToday(
        @RequestParam LocalDate hoy
    ) {
        return ResponseEntity.ok(sesionService.getToday(hoy));
    }

    @PostMapping("/")
    public ResponseEntity<SesionDTO> addSesion(
        @RequestBody SesionDTO sesionDTO
    ) {
        return ResponseEntity.ok(sesionService.addSesion(sesionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionDTO> updateSesion(
        @RequestBody SesionDTO sesionDTO
    ) {
        return ResponseEntity.ok(sesionService.updateSesion(sesionDTO));
    }
}
