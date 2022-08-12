package com.bosonit.MongoDBTemplate.domain;

import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaInputDto;
import com.bosonit.MongoDBTemplate.infraestructure.controller.dto.PersonaOutputDto;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private long edad;

    public PersonaOutputDto personaToPersonaOutputDto(Persona persona) {
        return new PersonaOutputDto(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEdad());
    }

    public Persona(PersonaInputDto personaInputDto) {

        this.nombre = personaInputDto.nombre();
        this.apellido = personaInputDto.apellido();
        this.edad = personaInputDto.edad();

    }
}
