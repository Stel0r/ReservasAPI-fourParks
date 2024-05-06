package com.example.ReservasAPI.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad,String> {
    
    
}
