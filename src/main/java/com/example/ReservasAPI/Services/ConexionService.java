package com.example.ReservasAPI.Services;

import java.rmi.server.ExportException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ReservasAPI.Logica.Conexion;
import com.example.ReservasAPI.Repositorios.ParqueaderoRepository;




public class ConexionService {
    private static ConexionService servicio;
    private Conexion conexion;

    private ConexionService() {
        conexion = Conexion.obtenerConexion();
    }

    public static ConexionService obtenerServicio() {
        if (servicio == null) {
            servicio = new ConexionService();
        }
        return servicio;
    }


    

}
