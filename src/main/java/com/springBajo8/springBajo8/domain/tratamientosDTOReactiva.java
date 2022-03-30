package com.springBajo8.springBajo8.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tratamientos")
public class tratamientosDTOReactiva {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String idTratamiento;

    private String nombreTratamiento;
    
    private String descripcionTratamiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getDescripcionTratamiento() {
        return descripcionTratamiento;
    }

    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }

    public String getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(String idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    
    
}
