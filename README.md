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
- ![estructura](https://github.com/C4r0l1n43ern4l/Challenge_Literalura/assets/90581744/44d23858-ca92-48ec-a657-ebcadb710f28)
- Como se puede visualizar en la imagen anterior, el proyecto cuanta con 4 paquetes:
- `Paquete Model:` Contiene los Records (DatosGutendex, DatosLibro y DatosAutor) para mapear los datos obtenidos de la API y las Clases (Libro y Autor) que servirán tanto para modelar las entidades en la Base de Datos y registrar información, como para mostrar en consola la información registrada en la BD.
- `Paquete Principal:` Contiene la clase Principal.java que es la encargada de la lógica del programa (Métodos para mostrar el menú, Consultar Datos en la API, Registrar datos en la BD y consultar información en la BD).
- `Paquete Repository:` Contiene las dos Interfaces que permitirán realizar el CRUD a la Base de Datos.
- `Paquete Service:` Contie las clases que para enviar y recibir infromación de la API y posteriormente convertir los datos JSON a una Clase.
## Abre y ejecuta el proyecto
- Una vez este abierto el proyecto en el IDE recomendado se debe ejecutar la clase LiteraluraApplication para poder usar la aplicación. Seguidamente empezará a visualizar el menú de opciones en donde podrá digitar la opción que desea como se muestra a continuación:
- ![menu-opciones](https://github.com/C4r0l1n43ern4l/conversor-de-moneda-challengealle/assets/90581744/a0ad8095-7a2c-4045-890b-3af1e6855b3c)
- Una vez seleccionada la opción el programa le mostrá un mensaje para que el usuario ingrese el monto de dinero a convertir:
- ![lectura-entradas](https://github.com/C4r0l1n43ern4l/conversor-de-moneda-challengealle/assets/90581744/5a92895a-34c4-422e-b681-3e19b3e53c10)
- Seguidamente el programa mostrará el resultado obtenido de la conversión y la fecha y hora de la consulta.
- ![resultado](https://github.com/C4r0l1n43ern4l/conversor-de-moneda-challengealle/assets/90581744/856e23e4-3653-47bb-87cc-5d4290d9d13d)
- Si el usuario ingresa una opción no válida el programa le mostrará un mensaje de error y le mostrará nuevamente el menú de opciones.
- ![opcion-invalida](https://github.com/C4r0l1n43ern4l/conversor-de-moneda-challengealle/assets/90581744/b3c87370-0fee-4fba-a512-79c0042eb3df)
- Si selecciona la opción de salir el programa le mostrará un ensaje de despedida.
- ![salida](https://github.com/C4r0l1n43ern4l/conversor-de-moneda-challengealle/assets/90581744/9a94f476-3109-468b-a9f0-36392920dadf)
## Tecnología Usada
- La aplicación fue desarrollada con el lenguaje de programación JavaSE17.
- Se utilizo el IDE IntelliJ.
- Spring y Postgres
- API Gutendex (https://gutendex.com/)
- Se utilizaron las clases HttpClient, HttpRequest y la interfaz HttpResponse, para crear el cliente, realizar la solicitud y obtener los datos necesarios para realizar una conversión.
## Autor
- Alba Carolina Bernal Carreño
