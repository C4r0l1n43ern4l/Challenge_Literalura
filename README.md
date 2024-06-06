# Challenge_Literalura

Este es un programa que fue desarrollado como el segundo Challenger propuesto por Alura - G6 en la especialización de Backend. 
El programa consiste en un catálogo de libros, en donde el usuario puede registrar libros en una Base de Datos y recibir información acerca de los libros registrados.
El desafio está enfocado en el consumo de una API y la persistencia de datos.

## Funcionalidades del proyecto
El proyecto ofrece varias funcionalidades entre ellas está:
- `Funcionalidad 1:` Mostrar al usuario un menú de opciones.
- `Funcionalidad 2:` Leer la opción seleccionada y a partir de ella realizar una acción.
- `Funcionalidad 3:` Consultar en la API GUTENDEX el libro ingresado por el usuario, verificar si existe y luego realizar la inserción en la base de Datos de dicho libro y su autor siempre y cuando no existan (De esta forma se evita suplicidad de la información).
- `Funcionalidad 4:` Listar los libros y autores registrados en la BD.
- `Funcionalidad 5:` Listar Autores vivos en un determinado año.
- `Funcionalidad 6:` Listar los libros por Idioma.
- `Funcionalidad 7:` Mostrar un Top 5 de libros más descargados.
- `Funcionalidad 8:` Salir del programa cuando el usuario lo desee.
## Cómo acceder al proyecto
Para poder acceder al proyecto se deben seguir los siguientes paso:
- Dirigise a la opción Code y posteriormente pulsar click en Download.zip
- Una vez descargado el proyecto se extrae la carpeta la cual se debe abrir con el IDE IntelliJ.
  
![estructura](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/44d23858-ca92-48ec-a657-ebcadb710f28)
- Como se puede visualizar en la imagen anterior, el proyecto cuanta con 4 paquetes:
- `Paquete Model:` Contiene los Records (DatosGutendex, DatosLibro y DatosAutor) para mapear los datos obtenidos de la API y las Clases (Libro y Autor) que servirán tanto para modelar las entidades en la Base de Datos y registrar información, como para mostrar en consola la información registrada en la BD.
- `Paquete Principal:` Contiene la clase Principal.java que es la encargada de la lógica del programa (Métodos para mostrar el menú, Consultar Datos en la API, Registrar datos en la BD y consultar información en la BD).
- `Paquete Repository:` Contiene las dos Interfaces que permitirán realizar el CRUD a la Base de Datos.
- `Paquete Service:` Contie las clases que para enviar y recibir infromación de la API y posteriormente convertir los datos JSON a una Clase.
- `Archivo pom.xml:` Contie las dependencias a utilizar (Spring Framework | Jackson Databind 2.17.0 | Spring Data JPA | Postgres.
  
## Abre y ejecuta el proyecto
- Una vez este abierto el proyecto en el IDE recomendado se debe ejecutar la clase LiteraluraApplication para poder usar la aplicación. Seguidamente empezará a visualizar el menú de opciones en donde podrá digitar la opción que desea como se muestra a continuación:
  
![menú](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/3f532a83-3837-4550-ae5f-f077a203b83c)
- `OPCIÓN 1 Buscar libro por título:` Busca en la API el libro y si no existe en la Base de Datos lo registra con su respectivo Autor.

![libroRegistrado](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/cfb09309-3f96-4e8e-99ce-afee41d8fd20)
![libroBD](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/acfdafda-2265-4148-a05d-14a6323dc1f9)
- NOTA: Si el libro existe no lo registra y envia un mensaje.
  
![libroValidado](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/ac5315d6-c260-4a49-975c-6ba0bb4f6362)
- `OPCIÓN 2 Listar libros registrados:` Muestra la lista de libros registrados en la BD.
  
![listaLibros](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/ff0a91c9-4b5e-439c-9d62-c10f540f0a7b)
- `OPCIÓN 3 Listar Autores registrados:` Muestra la lista de Autores registrados en la BD y ademas se pueden ver su lista de libros.
  
![listaAutores](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/8e344ffe-3a78-42e5-96e7-af714b04f796)
![autorBD](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/e0d7c557-aaf0-4349-a6d5-d89d46ec8ea3)
- `OPCIÓN 4 Listar Autores vivos en un determinado año:` Filtra los autores que estaban vivos a partir del año ingresado por el usuario.
  
![listaAutoresVivos](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/36683c9f-eafd-4f25-a78e-873a5062c6fb)
- `OPCIÓN 5 Listar libros por idioma:` Filtra los libros registrados en la BD A partir del idioma ingresado por el usuario.
  
![listalibroIdioma](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/6e764a73-edea-4b25-9fbf-c19a7ee86127)
- `OPCIÓN 6 Top 5 de Libros más descargados:` Muestra el top 5 de los libros que cuentan con mpas descargas.
  
![top5libros](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/9d48eb5a-1244-4bc5-9c93-a53438d8da2a)
- `OPCIÓN 0 Salir:` Permite al usuario finilizar la aplicación y salir.
  
![salir](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/9d5428a3-3f91-4bc5-8d23-f3220d6c1146)

## Tecnología Usada
- JavaSE17.
- IDE IntelliJ.
- Jackson Databind 2.17.0
- Spring y Postgres
- API Gutendex (https://gutendex.com/)
## Autor
- Alba Carolina Bernal Carreño
