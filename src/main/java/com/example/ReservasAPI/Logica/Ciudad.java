package com.example.ReservasAPI.Logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {
    @Id
    @Column(name = "K_COD_CIUDAD")
    public String codCiudad;
    @Column(name = "K_NOMBRE_CIUDAD")
    public String nombre;
}
