package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

<<<<<<< HEAD
    @Override
    public Flux<citasDTOReactiva> findPadecimientosByIdPaciente(String id) {
        Flux<citasDTOReactiva> pacientes = this.IcitasReactivaRepository.findByIdPaciente(id);

        pacientes.map(paciente -> paciente.getListaPadecimientos());

        return pacientes;
        
    }
=======
    //TO DO - Implementar funcionalidades
    @Override
    public Flux<citasDTOReactiva> findByDate(String date) {
        LocalDate ld= LocalDate.parse(date);
        return this.IcitasReactivaRepository.findByFechaReservaCita(ld);
    }

    @Override
    public Flux<citasDTOReactiva> findByHour(String hour) {
        return this.IcitasReactivaRepository.findByHoraReservaCita(hour);
    }

    @Override
    public Mono<citasDTOReactiva> findDoctorConsult(String id) {
        return this.IcitasReactivaRepository.findById(id).flatMap(
                d -> {
                    citasDTOReactiva doctor = new citasDTOReactiva();
                    doctor.setApellidosMedico(d.getApellidosMedico());
                    doctor.setNombreMedico(d.getNombreMedico());
                    return Mono.justOrEmpty(doctor);
                }
        );
    }

    @Override
    public Mono<citasDTOReactiva> cancelAppointment(String id) {
        return this.IcitasReactivaRepository.findById(id).flatMap(
                a -> {
                    a.setEstadoReservaCita("Cancelada");
                    return this.save(a);
                }
        ).switchIfEmpty(Mono.empty());
    }


>>>>>>> mishell-dev
}
