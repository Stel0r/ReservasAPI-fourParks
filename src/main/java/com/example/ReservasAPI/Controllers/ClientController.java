package com.example.ReservasAPI.Controllers;

import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReservasAPI.Logica.Cliente;
import com.example.ReservasAPI.Logica.Tarjeta;
import com.example.ReservasAPI.Logica.Usuario;
import com.example.ReservasAPI.Repositorios.ClienteID;
import com.example.ReservasAPI.Repositorios.ClienteRepository;
import com.example.ReservasAPI.Repositorios.TarjetaRepository;
import com.example.ReservasAPI.Repositorios.UsuarioRepository;
import com.example.ReservasAPI.RequestBody.UserUpdateInfo;

import jakarta.websocket.server.PathParam;


class InfoCardSend {
    public String idCard;
    public String namePro;
    public String numberCard;
    public int csv;
    public String dateExp;
    public long numDoc;
    public String typeDoc;
}


@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ClientController {

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public TarjetaRepository tarjetaRepository;
    @Autowired
    public UsuarioRepository usuarioRepository;

    @GetMapping("/misdatos/{usuario}")
    public Map<String,Object> misDatosUsuario(@PathVariable(value = "usuario") String usuario){
        return clienteRepository.obtenerMisDatos(usuario);
    }

    @GetMapping("/tarjetas")
    public List<Tarjeta> misDatosTarjetas(@RequestParam BigInteger numDoc,@RequestParam String tipoDoc){
        return tarjetaRepository.findAllByNumDocumentoAndTipoDoc(numDoc,tipoDoc);
    }


    @PostMapping("/tarjetas/agregar")
    public ResponseEntity<Map<String,Object>> agregarTarjeta(@RequestBody InfoCardSend body){
        try {
            Tarjeta tarjeta = new Tarjeta(body.idCard, body.numberCard, body.csv, body.namePro, Date.valueOf(body.dateExp), BigInteger.valueOf(body.numDoc), body.typeDoc);
            tarjetaRepository.save(tarjeta);
            return ResponseEntity.ok().body(Map.of("message","Se ha agregado la nueva tarjeta con exito !"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message","Oops! algo salio mal, nuestros monos ingenieros estan trabajando en ello"));
        }

    }


    @PatchMapping("/actualizar")
    public ResponseEntity<Map<String,Object>> actualizarDatos(@RequestBody UserUpdateInfo body){
        System.out.println(body);
        Cliente cliente = clienteRepository.findById(new ClienteID(body.typeDoc,BigInteger.valueOf(body.numDoc))).orElse(null);
        if (cliente != null){
            cliente.numCel = BigInteger.valueOf(body.numberCel);
        }else{
            return ResponseEntity.badRequest().body(Map.of("message","No se ha encontrado el Cliente"));
        }

        Usuario user = usuarioRepository.findById(body.nameUser).orElse(null);
        if (user != null){
            user.email = body.email;
            user.primerNombre = body.N_PRIMER_NOMBRE;
            user.segundoNombre = body.N_SEGUNDO_NOMBRE;
            user.primerApellido = body.N_PRIMER_APELLIDO;
            user.segundoApellido = body.N_SEGUNDO_APELLIDO;
        }else{
            return ResponseEntity.badRequest().body(Map.of("message","No se ha encontrado el Usuario"));
        }

        clienteRepository.save(cliente);
        usuarioRepository.save(user);
        return ResponseEntity.ok().body(Map.of("message","Se han actualizado los datos!"));
        
    }
    
}
