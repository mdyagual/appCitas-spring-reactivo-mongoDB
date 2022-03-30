package com.springBajo8.springBajo8.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.impl.citasReactivaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

@SpringBootTest
public class CitasReactivaServiceImplTest {

    @Autowired
    citasReactivaServiceImpl serviceTest;

    @Test
    void cancelarCitaTest(){
        citasDTOReactiva appointment = new citasDTOReactiva();

        appointment.setEstadoReservaCita("En proceso");

        Mono<citasDTOReactiva> appSave = serviceTest.save(appointment);

        Mono<citasDTOReactiva> appCanceled = serviceTest.cancelAppointment(appointment.getId());

        StepVerifier.create(appCanceled).expectComplete();

    }


}
