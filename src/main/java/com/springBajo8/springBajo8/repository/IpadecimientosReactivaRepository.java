package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IpadecimientosReactivaRepository extends ReactiveMongoRepository<padecimientosDTOReactiva, String>{

    //Mono<padecimientosDTOReactiva> findByIdAiling(String idPaciente);
    
}
