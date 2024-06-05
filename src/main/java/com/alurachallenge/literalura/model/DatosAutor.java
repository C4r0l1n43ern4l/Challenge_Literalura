/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer annioNacimiento,
        @JsonAlias("death_year") Integer annioFallecido) {
}
