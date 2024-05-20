package com.example.ReservasAPI.Logica;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TARJETA")
public class Tarjeta {

    @Id
    @Column(name="K_COD_TARJETA")
    public String identificador;
    @Column(name="Q_NUMERO")
    public String numTarjeta;
    @Column(name="K_CSV")
    public int codSegur;
    @Column(name="N_NOMBRE")
    public String nombrePropietario;
    @Column(name="F_VENCIMIENTO")
    public Date fechaVencimiento;
    @Column(name="K_NUM_DOCUMENTO")
    public BigInteger numDocumento;
    @Column(name="I_TIPO_DOC")
    public String tipoDoc;


    public Tarjeta(String identificador, String numTarjeta, int codSegur, String nombrePropietario,
            Date fechaVencimiento, BigInteger numDocumento, String tipoDoc) {
        this.identificador = identificador;
        this.numTarjeta = numTarjeta;
        this.codSegur = codSegur;
        this.nombrePropietario = nombrePropietario;
        this.fechaVencimiento = fechaVencimiento;
        this.numDocumento = numDocumento;
        this.tipoDoc = tipoDoc;
    }

    public Tarjeta() {
    }
}