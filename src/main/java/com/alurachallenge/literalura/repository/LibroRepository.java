/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.repository;

import com.alurachallenge.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByTituloContainsIgnoreCase(String titulo);

    @Query("SELECT l FROM Libro l WHERE l.idiomas LIKE :idioma")
    List<Libro> librosregistradosPorIdioma(String idioma);

    @Query("SELECT l FROM Libro l ORDER BY l.totalDeDescargas DESC LIMIT 5")
    List<Libro> top5LibrosMasDescargados();
}
