package org.eja.onepiece.pojo;

import java.io.Serializable;


public class ArchivoVideo implements Serializable{
    
    private String nombre;
    private String numero;
    private String rutaVisor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRutaVisor() {
        return rutaVisor;
    }

    public void setRutaVisor(String rutaVisor) {
        this.rutaVisor = rutaVisor;
    }
    
    
}
