package com.springBajo8.springBajo8.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;
import com.springBajo8.springBajo8.service.impl.citasReactivaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CitasReactivaServiceImplTest {

    @Autowired
    citasReactivaServiceImpl serviceTest;

    @Test
    void cancelarCitaTest(){
        citasDTOReactiva appointment = new citasDTOReactiva();
        appointment.setId("1");
        appointment.setEstadoReservaCita("En proceso");

        citasDTOReactiva appointment2 = new citasDTOReactiva();
        appointment.setId("1");
        appointment.setEstadoReservaCita("Cancelada");

        serviceTest.save(appointment);

        Mono<citasDTOReactiva> appCanceled = serviceTest.cancelAppointment("1");

        StepVerifier.create(appCanceled).expectNext(appointment2);

    }

    @Test
    void buscarPorFecha(){
        citasDTOReactiva appointment = new citasDTOReactiva();
        LocalDate ld = LocalDate.parse("2021-12-28");
        appointment.setFechaReservaCita(ld);
        serviceTest.save(appointment);

        Flux<citasDTOReactiva> appFound = serviceTest.findByDate(ld.toString());

        StepVerifier.create(appFound).expectNext(appointment);
    }

    @Test
    void buscarMedicoCita(){
        citasDTOReactiva appointment = new citasDTOReactiva();
        appointment.setId("1");
        appointment.setNombreMedico("Leónidas");
        appointment.setApellidosMedico("Coronado");

        serviceTest.save(appointment);

        Mono<citasDTOReactiva> appFound = serviceTest.findDoctorConsult("1");

        StepVerifier.create(appFound).expectNext(appointment);
    }


    @Test
    void buscarPadecimientosPaciente(){
        citasDTOReactiva appointment = new citasDTOReactiva();
        appointment.setIdPaciente("1");
        appointment.setListaPadecimientos(Arrays.asList(new padecimientosDTOReactiva(),new padecimientosDTOReactiva()));

        serviceTest.save(appointment);

        Flux<citasDTOReactiva> appFound = serviceTest.findAilingsByIdPaciente("1");

        StepVerifier.create(appFound).expectNext(appointment);
    }

    @Test
    void buscarTratamientosPaciente(){
        citasDTOReactiva appointment = new citasDTOReactiva();
        appointment.setIdPaciente("1");
        appointment.setListaTratamientos(Arrays.asList(new tratamientosDTOReactiva(),new tratamientosDTOReactiva()));

        serviceTest.save(appointment);

        Flux<citasDTOReactiva> appFound = serviceTest.findTreatmentsByIdPaciente("1");

        StepVerifier.create(appFound).expectNext(appointment);
    }
}
