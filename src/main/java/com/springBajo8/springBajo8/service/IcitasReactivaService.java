package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface IcitasReactivaService {
    Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> delete(String id);

    Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<citasDTOReactiva> findAll();

    Mono<citasDTOReactiva> findById(String id);

    //Método para imprimir solo los padecimientos de un paciente, dado su id
    Flux<citasDTOReactiva> findAilingsByIdPaciente(String id);

    //Método para imprimir solo los tratamientos de un paciente, dado su id
    Flux<citasDTOReactiva> findTreatmentsByIdPaciente(String id);

    Flux<citasDTOReactiva> findByDate(String date);

    Flux<citasDTOReactiva> findByHour(String date);

    Mono<citasDTOReactiva> findDoctorConsult(String id);

    Mono<citasDTOReactiva> cancelAppointment(String id);


}
