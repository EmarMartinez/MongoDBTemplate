package com.bosonit.MongoDBTemplate.application;

import com.bosonit.MongoDBTemplate.domain.Persona;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaInputDto;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaOutputDto;
import com.bosonit.MongoDBTemplate.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto guardarPersona(PersonaInputDto personaInputDto) {
       Persona persona = new Persona(personaInputDto);
       personaRepository.save(persona);
       return persona.personaToPersonaOutputDto(persona);

    }

    @Override
    public List<PersonaOutputDto> listaPersonas() {
        List<Persona> lista = personaRepository.findAll();
        return lista.stream().map(n->n.personaToPersonaOutputDto(n)).toList();
    }

    @Override
    public PersonaOutputDto borrarPersonaPorId(String id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(()->new Exception("Id no encontrada"));
        personaRepository.deleteById(id);
        return persona.personaToPersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto modificarPersonaPorId(String id, PersonaInputDto personaInputDto) throws Exception {
        personaRepository.findById(id).orElseThrow(()->new Exception("Id no encontrada"));
        Persona persona = new Persona(personaInputDto);
        persona.setId(id);
        return persona.personaToPersonaOutputDto(personaRepository.save(persona));
    }

    @Override
    public PersonaOutputDto buscarPersonaPorId(String id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(()->new Exception("Id no encontrada"));
        return persona.personaToPersonaOutputDto(persona);
    }
}
