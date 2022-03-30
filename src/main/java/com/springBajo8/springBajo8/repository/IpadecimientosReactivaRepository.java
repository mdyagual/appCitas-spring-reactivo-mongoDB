package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface IpadecimientosReactivaRepository extends ReactiveMongoRepository<padecimientosDTOReactiva, String>{

    Flux<padecimientosDTOReactiva> findByIdPadecimientos(String idPadecimiento);
    
}
