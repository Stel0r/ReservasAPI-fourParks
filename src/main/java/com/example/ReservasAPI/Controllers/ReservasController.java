package com.example.ReservasAPI.Controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Reserva;
import com.example.ReservasAPI.Repositorios.ClienteID;
import com.example.ReservasAPI.Repositorios.ReservasRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

class InterfazCreacionReserva{
    public String idReserva;
    public String fechaReserva;
    public String tiempoInicio;
    public String tiempoFinal;
    public int subTotal;
    public long numDocumento;
    public String tipoDoc;
    public String tipoVehiculo;
    public String codParqueadero;
}

@CrossOrigin
@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    public ReservasRepository reservasRepository;
    
    @GetMapping("")
    public ResponseEntity<List<Reserva>> obtenerReservasCliente(long doc, String tipoDoc){
        try {
            return ResponseEntity.ok().body(reservasRepository.findByNumDocumentoAndTipoDoc(BigInteger.valueOf(doc),tipoDoc));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ArrayList<Reserva>(){});
        }
    }


    @PutMapping("/agregarReserva")
    public ResponseEntity<Map<String,Object>> agregarReserva(@RequestBody InterfazCreacionReserva body){
        try {
            reservasRepository.registrarReserva(body.idReserva,Date.valueOf(body.fechaReserva), Time.valueOf(body.tiempoInicio), Time.valueOf(body.tiempoFinal), body.tipoVehiculo, BigInteger.valueOf(body.numDocumento), body.tipoDoc, body.codParqueadero,"10.0.0.0", body.subTotal);
            return ResponseEntity.ok().body(Map.of("Response","Se ha creado la nueva reserva"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Map.of("Response",e.getMessage()));
        }
    }


    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Object>> eliminarReserva(String id){
        try {
            reservasRepository.deleteById(id);
            return ResponseEntity.ok().body(Map.of("Response","Se ha eliminado la reserva"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Map.of("Response",e.getMessage()));
        }
    }

}
