package com.springBajo8.springBajo8.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "padecimientos")
public class padecimientosDTOReactiva {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String idPadecimiento;

    private String nombrePadecimiento;

    private String descripcionPadecimiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePadecimiento() {
        return nombrePadecimiento;
    }

    public void setNombrePadecimiento(String nombrePadecimiento) {
        this.nombrePadecimiento = nombrePadecimiento;
    }

    public String getDescripcionPadecimiento() {
        return descripcionPadecimiento;
    }

    public void setDescripcionPadecimiento(String descripcionPadecimiento) {
        this.descripcionPadecimiento = descripcionPadecimiento;
    }

    public String getIdPadecimiento() {
        return idPadecimiento;
    }

    public void setIdPadecimiento(String idPadecimiento) {
        this.idPadecimiento = idPadecimiento;
    }

    @Override
    public String toString() {
        return "padecimientosDTOReactiva [descripcionPadecimiento=" + descripcionPadecimiento + ", id=" + id
                + ", idPadecimiento=" + idPadecimiento + ", nombrePadecimiento=" + nombrePadecimiento + "]";
    }

    public padecimientosDTOReactiva(String idPadecimiento, String nombrePadecimiento, String descripcionPadecimiento) {
        this.idPadecimiento = idPadecimiento;
        this.nombrePadecimiento = nombrePadecimiento;
        this.descripcionPadecimiento = descripcionPadecimiento;
    }

    public padecimientosDTOReactiva(){

    }

    
    
}
