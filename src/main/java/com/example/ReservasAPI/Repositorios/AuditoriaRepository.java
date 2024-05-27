package com.example.ReservasAPI.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.ReservasAPI.Logica.Auditoria;

public interface AuditoriaRepository extends CrudRepository<Auditoria, Integer>{
    
}
