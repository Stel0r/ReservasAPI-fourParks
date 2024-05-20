package com.example.ReservasAPI.Controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Reserva;
import com.example.ReservasAPI.Repositorios.ClienteID;
import com.example.ReservasAPI.Repositorios.ReservasRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

class InterfazCreacionReserva{
    public String fechaReserva;
    public String fechaInicio;
    public String fechaFinal;
    public int subTotal;
    public float numDocumento;
    public String tipoDoc;
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
        return ResponseEntity.ok().body(Map.of("Response","el metodo aun esta en construccion"));
    }

}
