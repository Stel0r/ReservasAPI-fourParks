package com.example.ReservasAPI.Logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    public String usuario;
    private String tipo_cambio;
    private String elemento_cambiado;
    private java.sql.Timestamp fecha;
    private String direccionIP;
}
