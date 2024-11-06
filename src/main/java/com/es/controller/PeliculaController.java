package com.es.controller;

import com.es.dto.PeliculaDTO;
import com.es.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> createPelicula(
            @RequestBody PeliculaDTO peliculaDTO) {
        return ResponseEntity.ok(peliculaService.createPelicula(peliculaDTO));
    }

   
}
