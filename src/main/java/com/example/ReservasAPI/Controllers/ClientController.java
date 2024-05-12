package com.example.ReservasAPI.Controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Cliente;
import com.example.ReservasAPI.Logica.Tarjeta;
import com.example.ReservasAPI.Repositorios.ClienteRepository;
import com.example.ReservasAPI.Repositorios.TarjetaRepository;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ClientController {

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public TarjetaRepository tarjetaRepository;

    @GetMapping("/misdatos/{usuario}")
    public Map<String,Object> misDatosUsuario(@PathParam(value = "usuario") String usuario){
        return clienteRepository.obtenerMisDatos(usuario);
    }

    @GetMapping("/tarjetas")
    public List<Tarjeta> misDatosTarjetas(@RequestParam BigInteger numDoc,@RequestParam String tipoDoc){
        return tarjetaRepository.findAllByNumDocumentoAndTipoDoc(numDoc,tipoDoc);
    }
    
}
