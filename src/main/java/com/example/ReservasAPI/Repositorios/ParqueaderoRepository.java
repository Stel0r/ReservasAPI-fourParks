package com.example.ReservasAPI.Repositorios;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Parqueadero;

import jakarta.persistence.Column;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero,String>{    
    public List<Parqueadero> findBycodCiudad(String ciudad);

    @Query(value = "SELECT p.K_COD_PARQUEADERO,p.N_NOMBRE,p.I_ESTADO,p.I_24Hrs,p.F_HORA_APERTURA,p.F_HORA_CIERRE,I_FIDELIZACION,p.O_DIRECCION,p.O_LATITUD,p.O_LONGITUD,p.K_COD_GERENTE,p.K_COD_TIPO_PARQ,c.K_NOMBRE_CIUDAD,p.K_COD_TARIFA,p.N_NUM_PUESTOS from CIUDAD c,Parqueadero p WHERE p.K_COD_CIUDAD = c.K_COD_CIUDAD", nativeQuery = true)
    public List<Map<String,Object>> encontrarParqueaderos();
}


