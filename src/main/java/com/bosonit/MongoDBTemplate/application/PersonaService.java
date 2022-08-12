package com.bosonit.MongoDBTemplate.application;

import com.bosonit.MongoDBTemplate.domain.Persona;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaInputDto;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto guardarPersona(PersonaInputDto personaInputDto);
    List<PersonaOutputDto> listaPersonas();
    PersonaOutputDto borrarPersonaPorId(String id) throws Exception;
    PersonaOutputDto modificarPersonaPorId(String id, PersonaInputDto personaInputDto) throws Exception;
    PersonaOutputDto buscarPersonaPorId(String id) throws Exception;

}
