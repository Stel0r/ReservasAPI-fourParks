package com.example.ReservasAPI.Logica;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
    
    @Id
    @Column(name="K_COD_RESERVA")
    public String codReserva;
    @Column(name="F_FECHA_RESERVA")
    public Date fechaReserva;
    @Column(name="F_INICIO")
    public Date fechaInicio;
    @Column(name="F_FIN")
    public Date fechaFinal;
    @Column(name="F_SALIDA")
    public Date fechaSalida;
    @Column(name="O_DIR_IP")
    public String dirIp;
    @Column(name="I_ESTADO")
    public String estado;
    @Column(name="Q_SUB_TOTAL")
    public int subTotal;
    @Column(name="K_NUM_DOCUMENTO")
    public BigInteger numDocumento;
    @Column(name="I_TIPO_DOC")
    public String tipoDoc;

}
