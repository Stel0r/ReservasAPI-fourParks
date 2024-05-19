package com.example.ReservasAPI.Repositorios;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Parqueadero;


@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero,String>{    
    public List<Parqueadero> findBycodCiudad(String ciudad);

    @Query(value = "SELECT p.K_COD_PARQUEADERO as codParqueadero,p.N_NOMBRE as nombre,p.I_ESTADO as iEstado,p.I_24Hrs as i24Hrs,p.F_HORA_APERTURA horaApertura,p.F_HORA_CIERRE as horaCierre,I_FIDELIZACION iFidelizacion,p.O_DIRECCION as direccion,p.O_LATITUD as latitud,p.O_LONGITUD as longitud,p.K_COD_GERENTE as codGerente,p.K_COD_TIPO_PARQ tipoParqueadero,c.K_NOMBRE_CIUDAD ciudad,p.K_COD_TARIFA codTarifa,p.N_NUM_PUESTOS numPuestos from CIUDAD c,Parqueadero p WHERE p.K_COD_CIUDAD = c.K_COD_CIUDAD", nativeQuery = true)
    public List<Map<String,Object>> encontrarParqueaderos();
}


