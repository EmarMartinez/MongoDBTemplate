package com.bosonit.MongoDBTemplate.infraestructure.repository;

import com.bosonit.MongoDBTemplate.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {

}
