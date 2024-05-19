package com.example.ReservasAPI.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Reserva;

@Repository
public interface ReservasRepository extends CrudRepository<Reserva,String>{


    
}