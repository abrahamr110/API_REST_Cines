package com.es.controller;

import com.es.dto.PeliculaDTO;
import com.es.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    @GetMapping("/")
    public ResponseEntity<PeliculaDTO> getAll() {
        return ResponseEntity.ok(peliculaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getPelicula(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.getPelicula(id));
    }

    @GetMapping("/rating/{minRating}")
    public ResponseEntity<PeliculaDTO> getByMinRating(@PathVariable Double minRating) {
        return ResponseEntity.ok(peliculaService.getByMinRating(minRating));
    }

    @PostMapping("/")
    public ResponseEntity<PeliculaDTO> createPelicula(
            @RequestBody PeliculaDTO peliculaDTO) {
        return ResponseEntity.ok(peliculaService.createPelicula(peliculaDTO));
    }
}
