/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private String idiomas;
    private Integer totalDeDescargas;
    @ManyToOne()
    private Autor autores;


    //Constructor predeterminado
    public Libro(){
    }

    //Constructor con parámetros
    public Libro(DatosLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        this.autores = autor;
        this.idiomas = datosLibro.idiomas().get(0);
        this.totalDeDescargas = datosLibro.descargas();
    }

    //Métodos Getter y Setter
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getTotalDeDescargas() {
        return totalDeDescargas;
    }

    public void setTotalDeDescargas(Integer totalDeDescargas) {
        this.totalDeDescargas = totalDeDescargas;
    }

    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
        if (autores != null && !autores.getLibros().contains(this)){
            autores.getLibros().add(this);
        }
    }

    @Override
    public String toString() {
        return  "\n----- LIBRO -----" +
                "\nTitulo: '" + this.titulo +
                "\nAutor: "+ this.autores.getNombre() +
                "\nIdiomas: " + this.idiomas  +
                "\nTotal de Descargas: " + this.totalDeDescargas +
                "\n-----------------";
    }
}
