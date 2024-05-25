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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Ciudad;
import com.example.ReservasAPI.Logica.Parqueadero;
import com.example.ReservasAPI.Logica.Tarifa;
import com.example.ReservasAPI.Repositorios.CiudadRepository;
import com.example.ReservasAPI.Repositorios.ParqueaderoRepository;
import com.example.ReservasAPI.Repositorios.TarifaRepository;
import com.example.ReservasAPI.Services.ConexionService;

import jakarta.websocket.server.PathParam;

@RestController()
@CrossOrigin
@RequestMapping("/consulta")
public class BusquedaController {
    
    @Autowired
    private ParqueaderoRepository repositoryParqueadero;
    @Autowired
    private CiudadRepository repositoryCiudad;
    @Autowired
    private TarifaRepository repositoryTarifa;

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
    public ResponseEntity<List<Parqueadero>> obtenerParqueaderosPorCiudad(@PathVariable(value = "ciudad") String ciudad) throws ParseException{
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

    @GetMapping("/tarifas/{tarifa}")
    public ResponseEntity<Tarifa> obtenerTarifa(@PathVariable(value = "tarifa") String id){
        return ResponseEntity.ok().body(repositoryTarifa.findById(id).orElse(null));
        
    }

    @GetMapping("/tarifas")
    public ResponseEntity<List<Tarifa>> obtenerTarifas(){
        return ResponseEntity.ok().body((List<Tarifa>)repositoryTarifa.findAll());
        
    }
}
