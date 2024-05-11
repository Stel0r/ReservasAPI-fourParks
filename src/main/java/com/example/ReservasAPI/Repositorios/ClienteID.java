package com.example.ReservasAPI.Repositorios;

import java.io.Serializable;
import java.math.BigInteger;

import com.example.ReservasAPI.Logica.Cliente;



public class ClienteID implements Serializable {

    public String tipoDocumento;
    public BigInteger numDoc;

    public ClienteID(){}

    public ClienteID(String tipoDocumento, BigInteger numDoc) {
        this.tipoDocumento = tipoDocumento;
        this.numDoc = numDoc;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
