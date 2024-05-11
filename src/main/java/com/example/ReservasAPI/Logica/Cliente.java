package com.example.ReservasAPI.Logica;

import java.math.BigInteger;

import com.example.ReservasAPI.Repositorios.ClienteID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ClienteID.class)
@Table(name = "CLIENTE")
public class Cliente {

@Id
@Column(name = "I_TIPO_DOC")
String tipoDocumento;
@Id
@Column(name = "K_NUM_DOCUMENTO")
BigInteger numDoc;
@Column(name = "Q_NUM_CELULAR")
BigInteger numCel;
@Column(name = "N_NOMBRE_USUARIO")
String nomUsuario;
@Column(name = "N_PTS_FIDELIZACIÓN")
int ptsFidelizacion;



    
}
