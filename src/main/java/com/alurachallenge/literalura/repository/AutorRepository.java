/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.repository;

import com.alurachallenge.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNombre (String nombre);

    @Query("SELECT a FROM Autor a WHERE a.annioNacimiento <= :annio AND a.annioFallecido > :annio")
    List<Autor> autoresVivosPorAnnio(int annio);

}
