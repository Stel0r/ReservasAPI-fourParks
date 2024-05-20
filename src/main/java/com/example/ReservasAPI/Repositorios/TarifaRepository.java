package com.example.ReservasAPI.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Tarifa;

@Repository
public interface TarifaRepository extends CrudRepository<Tarifa,String>{
    
}
