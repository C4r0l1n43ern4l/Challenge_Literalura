/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosGutendex(
        @JsonAlias("count") Integer numeroDeRegistros,
        @JsonAlias("results") List<DatosLibro> informacionDelLibro
) {
}
