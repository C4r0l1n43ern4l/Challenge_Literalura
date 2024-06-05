/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer annioNacimiento;
    private Integer annioFallecido;
    @OneToMany(mappedBy = "autores", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Libro> libros;

    //Constructor predeterminado
    public Autor() {
    }

    //Constructor con parámetros
    public Autor(DatosAutor a) {
        this.nombre = a.nombre();
        this.annioNacimiento = a.annioNacimiento();
        this.annioFallecido = a.annioFallecido();
    }

    //Métodos Getter y Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
       return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnnioNacimiento() {
        return annioNacimiento;
    }

    public void setAnnioNacimiento(Integer annioNacimiento) {
        this.annioNacimiento = annioNacimiento;
    }

    public Integer getAnnioFallecido() {
        return annioFallecido;
    }

    public void setAnnioFallecido(Integer annioFallecido) {
        this.annioFallecido = annioFallecido;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
        for (Libro libro : libros){
            libro.setAutores(this);
        }
    }

    @Override
    public String toString() {
        return "\n----- AUTOR -----" +
                "\nNombre: " + this.nombre +
                "\nAño de Nacimiento: " + this.annioNacimiento +
                "\nAño de Fallecimiento: " + this.annioFallecido +
                "\nLibros: " + (libros != null ? libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(" | ")) : "N/A") +
                "\n-----------------";
    }
}
