package com.example.ReservasAPI.Logica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANUNCIOS")
public class Anuncios {
    @Id
    public int anuncioId;
    public String titulo; 
    public String contenido; 
    public String img; 
}


