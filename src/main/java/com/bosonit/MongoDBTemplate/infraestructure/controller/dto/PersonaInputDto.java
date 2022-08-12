package com.bosonit.MongoDBTemplate.infraestructure.controller.dto;

public record PersonaInputDto(String nombre,
                              String apellido,
                              long edad) {
}
