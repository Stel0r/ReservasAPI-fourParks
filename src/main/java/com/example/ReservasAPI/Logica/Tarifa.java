package com.example.ReservasAPI.Logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TARIFA")
public class Tarifa {
    @Id
    @Column(name="K_COD_TARIFA")
    public String idTarifa;
    @Column(name="N_PRECIO_PH_C")
    public int tarifaCarro;
    @Column(name="N_PRECIO_EXTRA_PH_C")
    public int tarifaExtraCarro;
    @Column(name="N_PRECIO_PH_M")
    public int tarifaMoto;
    @Column(name="N_PRECIO_EXTRA_PH_M")
    public int tarifaExtraMoto;


}
