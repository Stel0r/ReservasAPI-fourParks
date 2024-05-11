package com.example.ReservasAPI.Repositorios;

import java.util.List;

import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,ClienteID>{

    @Query(value = "SELECT C.*,U.N_NOMBRE_USUARIO,U.O_EMAIL,U.I_ROL,U.I_ESTADO,U.N_PRIMER_NOMBRE, U.N_PRIMER_APELLIDO, U.N_SEGUNDO_NOMBRE, U.N_SEGUNDO_APELLIDO from CLIENTE C LEFT JOIN USUARIO U ON (C.N_NOMBRE_USUARIO = U.N_NOMBRE_USUARIO) WHERE  U.N_NOMBRE_USUARIO = ?1",nativeQuery = true)
    public Map<String,Object> obtenerMisDatos(String cliente);
    
}
