
package com.uaemex.fiuaemex.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


//aqui solo son geters y setters ,no se programa nada mas que eso.

public class InsertaPersonaDto {
    private long id;
    private String nombre;
    private String apellidos;
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "InsertaPersonaDto{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
}
