package com.bosonit.MongoDBTemplate.infraestructure.controller.dto;

public record PersonaOutputDto(String id,
                               String nombre,
                               String apellido,
                               long edad) {
}
