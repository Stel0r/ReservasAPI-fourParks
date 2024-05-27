package com.example.ReservasAPI.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReservasAPI.Logica.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer>{
    
}
