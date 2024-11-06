package com.es.controller;

import com.es.dto.SesionDTO;
import com.es.service.SesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
