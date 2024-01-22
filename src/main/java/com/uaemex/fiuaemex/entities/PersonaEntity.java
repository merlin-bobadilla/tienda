package com.uaemex.fiuaemex.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persona", schema = "practicaspring")
public class PersonaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Long id;

    @Column(name = "NOMBRE_PERSONA", length = 50, nullable = false)
    private String nombrePersona;

    @Column(name = "APELLIDOS_PERSONA", length = 50, nullable = false)
    private String apellidosPersona;

    @Column(name = "SEXO_PERSONA", length = 1, nullable = false)
    private String sexoPersona;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO_PERSONA")
    private Date fechaNacimientoPersona;

    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade={CascadeType.ALL})
    private List<TiendaEntity> tienda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public String getSexoPersona() {
        return sexoPersona;
    }

    public void setSexoPersona(String sexoPersona) {
        this.sexoPersona = sexoPersona;
    }

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    public List<TiendaEntity> getTienda() {
        return tienda;
    }

    public void setTienda(List<TiendaEntity> tienda) {
        this.tienda = tienda;
    }

}
