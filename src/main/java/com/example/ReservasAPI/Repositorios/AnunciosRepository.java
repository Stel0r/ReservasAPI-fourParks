package com.example.ReservasAPI.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Anuncios;

@Repository
public interface AnunciosRepository extends CrudRepository<Anuncios,Integer>{
    
    public List<Anuncios> findAllByOrderByAnuncioIdDesc();

}
