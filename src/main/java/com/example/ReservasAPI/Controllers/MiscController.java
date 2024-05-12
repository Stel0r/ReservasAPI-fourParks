package com.example.ReservasAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Anuncios;
import com.example.ReservasAPI.Repositorios.AnunciosRepository;

@RestController
@CrossOrigin
public class MiscController {

    @Autowired
    public AnunciosRepository anunciosRepository; 

    @GetMapping("/Anuncios")
    public List<Anuncios> obtenerAnuncios(){
        return anunciosRepository.findAllByOrderByAnuncioIdDesc();
    }
}
