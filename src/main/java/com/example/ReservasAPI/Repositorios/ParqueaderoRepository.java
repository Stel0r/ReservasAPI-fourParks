package com.example.ReservasAPI.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Parqueadero;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero,String>{    
    public List<Parqueadero> findBycodCiudad(String ciudad);
}
