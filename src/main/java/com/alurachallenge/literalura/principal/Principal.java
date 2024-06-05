/* @Carolina Bernal (C4r0l1n43ern4l) - Challenger 2 ALURA - LITERALURA - Java y Spring Boot G6 - ONE */
package com.alurachallenge.literalura.principal;

import com.alurachallenge.literalura.model.*;
import com.alurachallenge.literalura.repository.AutorRepository;
import com.alurachallenge.literalura.repository.LibroRepository;
import com.alurachallenge.literalura.service.ConsumoAPI;
import com.alurachallenge.literalura.service.ConvierteDatos;
import com.alurachallenge.literalura.model.Libro;

import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private LibroRepository repositorioLibro;
    private AutorRepository repositorioAutor;

    public Principal(LibroRepository repository, AutorRepository repositoryAutor) {
        this.repositorioLibro = repository;
        this.repositorioAutor = repositoryAutor;
    }


    public void mostrarElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    \n
                    Elija la opción a través de su número:
                    
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar Autores registrados
                    4 - Listar Autores vivos en un determinado año
                    5 - Listar libros por idioma
                    6 - Top 5 de Libros más descargados
                                              
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    top5LibrosMasDescargados();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    //Método para buscar libros por título consumiendo la API Gutendex
    private void buscarLibroPorTitulo() {
        System.out.println("************* BUSCAR LIBROS POR TITULO *************");
        System.out.println("Por favor escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ","+"));
        System.out.println(json);
        List<DatosLibro> datos = conversor.obtenerDatos(json, DatosGutendex.class).informacionDelLibro();

        Optional<DatosLibro> libroBuscado = datos.stream()
                .filter(l -> l.titulo().toLowerCase().contains(nombreLibro.toLowerCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            DatosLibro datosLibro = libroBuscado.get();
            DatosAutor datosAutor = datosLibro.autor().get(0);

            Autor autor = repositorioAutor.findByNombre(datosAutor.nombre());
            if (autor == null){
                autor= new Autor(datosAutor);
                repositorioAutor.save(autor);
            }

            Libro libro = repositorioLibro.findByTituloContainsIgnoreCase(datosLibro.titulo());
            if (libro == null){
                libro = new Libro(datosLibro, autor);
                repositorioLibro.save(libro);
                System.out.println(libro.toString());
            } else {
                System.out.println("¡El libro ya se encuentra registrado en la Base de Datos.\n " +
                        "No se puede registrar el mismo libro más de una vez!");
            }

        } else {
            System.out.println("¡El libro que intenta buscar no ha sido encontrado!");
        }

    }

    //Método para Listar los libros registrados en la Base de Datos
    private void listarLibrosRegistrados(){
        System.out.println("************* LIBROS REGISTRADOS EN LA BASE DE DATOS *************");
        List<Libro> listadoDeLibros = repositorioLibro.findAll();

        listadoDeLibros.stream()
               .forEach(System.out::println);
    }

    //Método para Listar autores registrados en la Base de Datos
    private void listarAutoresRegistrados(){
        System.out.println("************* AUTORES REGISTRADOS EN LA BASE DE DATOS *************");
        List<Autor>  listadoDeAutores = repositorioAutor.findAll();

        listadoDeAutores.stream()
                        .forEach(System.out::println);
    }

    //Método para Listar autores vivos en determinado año
    private void listarAutoresVivos(){
        System.out.println("************* AUTORES VIVOS EN DETERMINADO AÑO *************");
        System.out.println("Por favor ingrese el año");
        var annio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> filtroAutores = repositorioAutor.autoresVivosPorAnnio(annio);

        if(!filtroAutores.isEmpty()){
            filtroAutores.forEach(System.out::println);
        } else {
            System.out.println("¡No existen registros de Autores vivos en el año " + annio);
        }
    }

    //Método para Listar autores vivos en determinado año
    private void listarLibrosPorIdioma(){
        System.out.println("************* LISTAR LIBROS POR IDIOMA *************");
        System.out.println("Ingresa las iniciales del idioma de los libros que deseas visualizar" +
                "\nes - Español" +
                "\nen - Inglés" +
                "\nfr - Francés" +
                "\npt - Portugués");
        String lenguaje = teclado.nextLine();

        List<Libro> filtroLibrosPorIdioma = repositorioLibro.librosregistradosPorIdioma(lenguaje.toLowerCase());

        if(!filtroLibrosPorIdioma.isEmpty()){
            filtroLibrosPorIdioma.forEach(System.out::println);
        } else {
            System.out.println("¡No existen registros de libros por el idioma ingresado!");
        }
    }

    //Método para mostrar el TOP 5 de libros más descargados
    private void top5LibrosMasDescargados(){
        System.out.println("************* TOP 5 LIBROS MÁS DESCARGADOS *************");

        List<Libro> librosMasDescargados = repositorioLibro.top5LibrosMasDescargados();

        librosMasDescargados.forEach(System.out::println);
    }

}
