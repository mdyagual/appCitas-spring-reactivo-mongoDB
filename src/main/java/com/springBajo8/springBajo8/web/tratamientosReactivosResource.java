package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;
import com.springBajo8.springBajo8.service.ItratamientosReactivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class tratamientosReactivosResource {
    
    @Autowired
    private ItratamientosReactivaService tratamientosService;

    @PostMapping("/tratamientosReactivos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<tratamientosDTOReactiva> save(@RequestBody tratamientosDTOReactiva tratamiento){
        return this.tratamientosService.save(tratamiento);
    }


    @DeleteMapping("/tratamientosReactivos/{id}")
    private Mono<ResponseEntity<tratamientosDTOReactiva>> delete(@PathVariable("id") String id){
        return this.tratamientosService.delete(id)
                .flatMap(tratamiento -> Mono.just(ResponseEntity.ok(tratamiento)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @PutMapping("/tratamientosReactivos/{id}")
    private Mono<ResponseEntity<tratamientosDTOReactiva>> update(@PathVariable("id") String id,
                                                @RequestBody tratamientosDTOReactiva tratamiento)
    {
        return this.tratamientosService.update(id, tratamiento)
                .flatMap(tratamientoDTO -> Mono.just(ResponseEntity.ok(tratamientoDTO)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    
    @GetMapping("/tratamientosReactivos/{id}/byIdTratamiento")
    private Flux<tratamientosDTOReactiva> findAllByIdTratamiento(@PathVariable("id") String id){
        return this.tratamientosService.findByIdTratamiento(id);
    }


    @GetMapping(value = "/tratamientosReactivos")
    private Flux<tratamientosDTOReactiva> findAll(){
        return this.tratamientosService.findAll();
    }
}
