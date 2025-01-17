package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class citasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        
        //System.out.println("Tratamientos " + citasDTOReactiva.getListaTratamientos());
        //System.out.println("Padecimientos " + citasDTOReactiva.getListaPadecimientos());

        return this.icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }



    @GetMapping("/citasReactivas/{id}/findPadecimientos")
    private Flux<citasDTOReactiva> obtenerPadecimientosByIdPaciente(@PathVariable("id") String id) {
        return this.icitasReactivaService.findAilingsByIdPaciente(id);
    }

    @GetMapping("/citasReactivas/{id}/findTratamientos")
    private Flux<citasDTOReactiva> obtenerTratamientosByIdPaciente(@PathVariable("id") String id) {
        return this.icitasReactivaService.findTreatmentsByIdPaciente(id);
    }

    //TO DO: Primeras 3 funcionalidades
    @GetMapping(value = "/citasReactivas/buscarFecha/{fecha}")
    private Flux<citasDTOReactiva> buscarPorFecha(@PathVariable("fecha") String fecha) {
        return this.icitasReactivaService.findByDate(fecha);
    }

    @GetMapping(value = "/citasReactivas/buscarHora/{hora}")
    private Flux<citasDTOReactiva> buscarPorHora(@PathVariable("hora") String hora) {
        return this.icitasReactivaService.findByHour(hora);
    }

    @GetMapping(value = "/citasReactivas/buscarDoctorConsulta/{consultaId}")
    private Mono<citasDTOReactiva> buscarDoctorConsulta(@PathVariable("consultaId") String consultaId) {
        return this.icitasReactivaService.findDoctorConsult(consultaId);
    }

    @PutMapping("/citasReactivas/cancelarCita/{id}")
    private Mono<citasDTOReactiva> cancelarCita(@PathVariable("id") String id) {
        return this.icitasReactivaService.cancelAppointment(id);

    }

}
