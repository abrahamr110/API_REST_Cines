package com.es.service;

import com.es.dto.PeliculaDTO;
import com.es.dto.SesionDTO;
import com.es.entities.Pelicula;
import com.es.entities.Sesion;
import com.es.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Service
public class SesionService {
    @Autowired
    private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    private SesionDTO mapToDTO(Sesion sesion) {
        SesionDTO sesionDTO = new SesionDTO();
        sesionDTO.setId(sesion.getId());
        sesionDTO.setMovieId(sesion.getPelicula().getId());
        sesionDTO.setRoomId(sesion.getRoomId());
        sesionDTO.setDate(sesion.getDate());
        return sesionDTO;
    }

    public SesionDTO getAll(){
        Sesion sesion = sesionRepository.findAll().get(0);
        return mapToDTO(sesion);
    }

    public SesionDTO getToday(LocalDate date){
        for(Sesion sesion : sesionRepository.findAll()){
            if(sesion.getDate().equals(date)){
                return mapToDTO(sesion);
            }
        }
        return null;
    }
}
