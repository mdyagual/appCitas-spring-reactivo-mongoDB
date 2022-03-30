package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.service.IpadecimientosReactivaService;

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
public class padecimientosReactivaResource {

    @Autowired
    private IpadecimientosReactivaService padecimientosServices;

    @PostMapping("/padecimientosReactivos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<padecimientosDTOReactiva> save(@RequestBody padecimientosDTOReactiva padecimiento){
        return this.padecimientosServices.save(padecimiento);
    }

    @DeleteMapping("/padecimientosReactivos/{id}")
    private Mono<ResponseEntity<padecimientosDTOReactiva>> delete(@PathVariable("id") String id){
        return this.padecimientosServices.delete(id)
                .flatMap(padecimiento -> Mono.just(ResponseEntity.ok(padecimiento)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
    
    @PutMapping("/padecimientosReactivos/{id}")
    private Mono<ResponseEntity<padecimientosDTOReactiva>> update(@PathVariable("id") String id, 
                                            @RequestBody padecimientosDTOReactiva padecimiento)
    {
        return this.padecimientosServices.update(id, padecimiento)
                .flatMap(padecimientoDTO -> Mono.just(ResponseEntity.ok(padecimientoDTO)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


    @GetMapping("/padecimientosReactivos/{id}/byIdPadecimiento")
    private Flux<padecimientosDTOReactiva> findAllByIdPadecimiento(@PathVariable("id") String id){
        return this.padecimientosServices.findByIdPadecimiento(id);
    }


    @GetMapping(value = "/padecimientosReactivos")
    private Flux<padecimientosDTOReactiva> findAll(){
        return this.padecimientosServices.findAll();
    }
}
