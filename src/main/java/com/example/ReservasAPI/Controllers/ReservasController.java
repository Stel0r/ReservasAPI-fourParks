package com.example.ReservasAPI.Controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

import ch.qos.logback.core.boolex.Matcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import com.example.ReservasAPI.Services.AuditoriaService;
class InterfazCreacionReserva{
    public String idReserva;
    public String fechaReserva;
    public String tiempoInicio;
    public String tiempoFinal;
    public float subTotal;
    public long numDocumento;
    public String tipoDoc;
    public String tipoVehiculo;
    public String codParqueadero;
}

@RestController
@CrossOrigin
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    public ReservasRepository reservasRepository;
    
    @Autowired
    public AuditoriaService auditoriaService;


    @GetMapping("")
    public ResponseEntity<List<Reserva>> obtenerReservas(long doc,String tipoDoc){
        return ResponseEntity.ok().body(reservasRepository.findByNumDocumentoAndTipoDoc(BigInteger.valueOf(doc), tipoDoc));
    }

    @PutMapping("/agregarReserva")
    @Transactional
    public ResponseEntity<Map<String,Object>> agregarReserva(@RequestBody InterfazCreacionReserva body,HttpServletRequest request){
        try {
            reservasRepository.registrarReserva(body.idReserva,Date.valueOf(body.fechaReserva), Time.valueOf(body.tiempoInicio), Time.valueOf(body.tiempoFinal), body.tipoVehiculo, BigInteger.valueOf(body.numDocumento), body.tipoDoc, body.codParqueadero,request.getRemoteAddr(), body.subTotal);
            auditoriaService.registrar("Creacion Reserva", body.idReserva, request.getRemoteAddr());
            return ResponseEntity.ok().body(Map.of("Response","Se ha creado la nueva reserva"));
        } catch (Exception e) {
            String error = e.getMessage().split("##").length == 0 ? e.getMessage():e.getMessage().split("##")[1];
            return ResponseEntity.badRequest().body(Map.of("Response",error));
        }
    }


    @DeleteMapping("/cancelar")
    public ResponseEntity<Map<String,Object>> eliminarReserva(String id, HttpServletRequest request){
        try {
            Reserva res = reservasRepository.findById(id).orElseThrow();
            res.estado = "C";
            reservasRepository.save(res);
            auditoriaService.registrar("Cancelacion Reserva", id, request.getRemoteAddr());
            return ResponseEntity.ok().body(Map.of("Response","Se ha cancelado la reserva"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("Response",e.getMessage().split("##")[1]));
        }
    }
    @PatchMapping("/actualizar")
    public ResponseEntity<Map<String,Object>> modificarReserva(@RequestBody InterfazCreacionReserva body, HttpServletRequest request){
        try {
            reservasRepository.modificarReserva(body.idReserva,Date.valueOf(body.fechaReserva), Time.valueOf(body.tiempoInicio), Time.valueOf(body.tiempoFinal),request.getRemoteAddr(),body.subTotal);
            auditoriaService.registrar("Modificacion Reserva", body.idReserva, request.getRemoteAddr());
            return ResponseEntity.ok().body(Map.of("Response","Se ha modificado la reserva con exito"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("Response",e.getMessage().split("##")[1]));
        }
    }
}
