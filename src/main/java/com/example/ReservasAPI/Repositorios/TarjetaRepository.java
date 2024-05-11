package com.example.ReservasAPI.Repositorios;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta,String>{

    public List<Tarjeta> findAllByNumDocumentoAndTipoDoc(BigInteger numDocumento,String tipoDoc);
}
