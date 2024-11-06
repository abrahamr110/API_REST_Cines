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

    public SesionDTO addSesion(SesionDTO sesionDTO){
        Sesion sesion= new Sesion();
        Pelicula pelicula=new Pelicula();

        pelicula.setId(sesionDTO.getMovieId());
        sesion.setPelicula(pelicula);
        sesion.setId(sesionDTO.getId());
        sesion.setRoomId(sesionDTO.getRoomId());
        sesion.setDate(sesionDTO.getDate());

        sesionRepository.save(sesion);

        return sesionDTO;
    }

    public SesionDTO updateSesion(SesionDTO sesionDTO){
        Sesion sesion=sesionRepository.findAll().get(0);
        Pelicula pelicula=new Pelicula();

        if(sesion != null){
            sesion.setId(sesionDTO.getId());
            pelicula.setId(sesionDTO.getMovieId());
            sesion.setPelicula(pelicula);
            sesion.setRoomId(sesionDTO.getRoomId());
            sesion.setDate(sesionDTO.getDate());

            sesionRepository.save(sesion);

            return sesionDTO;
        }else{
            return null;
        }

    }

    public SesionDTO deleteSesion(Long id){
        Sesion sesion=sesionRepository.findAll().get(0);

        if(sesion!=null){
            sesionRepository.delete(sesion);
            return mapToDTO(sesion);
        }else{
            return null;
        }
    }
}
