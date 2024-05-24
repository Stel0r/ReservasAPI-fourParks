package com.example.ReservasAPI.Repositorios;


import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,ClienteID>{

}
