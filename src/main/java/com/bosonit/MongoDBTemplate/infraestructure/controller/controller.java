package com.bosonit.MongoDBTemplate.infraestructure.controller;

import com.bosonit.MongoDBTemplate.application.PersonaServiceImpl;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaInputDto;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping("/persona")
    public PersonaOutputDto guardarPersona(@RequestBody PersonaInputDto personaInputDto) {
        return personaServiceImpl.guardarPersona(personaInputDto);
    }

    @GetMapping("/persona/lista")
    public List<PersonaOutputDto> devolverTodos() {
        return personaServiceImpl.listaPersonas();
    }

    @DeleteMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> borrarPorId(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personaServiceImpl.borrarPersonaPorId(id), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> modificarPorId(@PathVariable String id,@RequestBody PersonaInputDto personaInputDto) {
        try {
            return new ResponseEntity<>(personaServiceImpl.modificarPersonaPorId(id, personaInputDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> buscarPorId(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personaServiceImpl.buscarPersonaPorId(id), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
