package com.example.ReservasAPI.Repositorios;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ReservasAPI.Logica.Reserva;

@Repository
public interface ReservasRepository extends CrudRepository<Reserva,String>{

    public List<Reserva> findByNumDocumentoAndTipoDoc(BigInteger doc,String tipoDoc);

    @Procedure("registrar_reserva")
    public void registrarReserva(
        String p_cod_reserva,
        Date p_fecha_reserva,
        Time p_inicio,
        Time p_fin,
        String p_tipo_v,
        BigInteger p_num_documento,
        String p_tipo_doc,
        String p_cod_parqueadero ,
        String p_ip,
        float p_subtotal);

    @Procedure("modificar_reserva")
    public void modificarReserva(
        String p_cod_reserva,
        Date p_fecha_reserva,
        Time p_inicio,
        Time p_fin
    );
    
}
