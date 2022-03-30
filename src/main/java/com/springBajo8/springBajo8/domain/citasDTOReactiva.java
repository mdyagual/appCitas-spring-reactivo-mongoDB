package com.springBajo8.springBajo8.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
//import java.util.Date;
import java.util.UUID;

@Document(collection = "citas")
public class citasDTOReactiva {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String idPaciente;

    private String nombrePaciente;

    private String apellidosPaciente;

    private String nombreMedico;

    private String apellidosMedico;

    private LocalDate fechaReservaCita;

    private String horaReservaCita;

    private String estadoReservaCita;

    //Agregando referencias a los otros dominios

    @DBRef
    private tratamientosDTOReactiva tratamiento;

    @DBRef
    private List<tratamientosDTOReactiva> listaTratamientos;

    @DBRef
    private padecimientosDTOReactiva padecimiento;

    @DBRef
    private List<padecimientosDTOReactiva> listaPadecimientos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        this.apellidosMedico = apellidosMedico;
    }

    public LocalDate getFechaReservaCita() {
        return fechaReservaCita;
    }

    public void setFechaReservaCita(LocalDate fechaReservaCita) {
        this.fechaReservaCita = fechaReservaCita;
    }

    public String getHoraReservaCita() {
        return horaReservaCita;
    }

    public void setHoraReservaCita(String horaReservaCita) {
        this.horaReservaCita = horaReservaCita;
    }

    public String getEstadoReservaCita() {
        return estadoReservaCita;
    }

    public void setEstadoReservaCita(String estadoReservaCita) {
        this.estadoReservaCita = estadoReservaCita;
    }

    public tratamientosDTOReactiva getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(tratamientosDTOReactiva tratamiento) {
        this.tratamiento = tratamiento;
    }

    public List<tratamientosDTOReactiva> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(List<tratamientosDTOReactiva> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public padecimientosDTOReactiva getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(padecimientosDTOReactiva padecimiento) {
        this.padecimiento = padecimiento;
    }

    public List<padecimientosDTOReactiva> getListaPadecimientos() {
        return listaPadecimientos;
    }

    public void setListaPadecimientos(List<padecimientosDTOReactiva> listaPadecimientos) {
        this.listaPadecimientos = listaPadecimientos;
    }

    //private Date sendedDate = new Date();

    

}
