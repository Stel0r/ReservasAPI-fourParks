package com.example.ReservasAPI.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Ciudad;
import com.example.ReservasAPI.Logica.Parqueadero;
import com.example.ReservasAPI.Repositorios.CiudadRepository;
import com.example.ReservasAPI.Repositorios.ParqueaderoRepository;
import com.example.ReservasAPI.Services.ConexionService;

import jakarta.websocket.server.PathParam;

@RestController
public class BusquedaController {
    
    private ConexionService DBServicio = ConexionService.obtenerServicio();
    @Autowired
    private ParqueaderoRepository repositoryParqueadero;
    @Autowired
    private CiudadRepository repositoryCiudad;

    @GetMapping("/parqueaderos")
    public ResponseEntity<List<Parqueadero>> obtenerParqueaderos() throws ParseException{
        ArrayList<Parqueadero> response = new ArrayList<Parqueadero>();
        for(Parqueadero i : repositoryParqueadero.findAll()){
            response.add(i);
        }
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/parqueaderosCiudad")
    public ResponseEntity<List<Map<String,Object>>> obtenerParqueaderosCiudad() throws ParseException{
        return ResponseEntity.ok().body(repositoryParqueadero.encontrarParqueaderos());
    }

    @GetMapping("/parqueaderos/{ciudad}")
    public ResponseEntity<List<Parqueadero>> obtenerParqueaderosPorCiudad(@PathParam(value = "ciudad") String ciudad) throws ParseException{
        return ResponseEntity.ok().body(repositoryParqueadero.findBycodCiudad(ciudad));
    }

    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudad>> obtenerCiudades() throws ParseException{
        ArrayList<Ciudad> response = new ArrayList<Ciudad>();
        for(Ciudad i : repositoryCiudad.findAll()){
            response.add(i);
        }
        return ResponseEntity.ok().body(response);
    }

}
