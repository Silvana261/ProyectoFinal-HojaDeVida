# Manual de usuario

## Requisitos previos:

Antes de empezar, asegúrate de tener instalados:

- Java JDK 11 o superior
- Apache Maven  
- Apache Tomcat 10.1.49
- MongoDB Community Server (debe estar conctado a: localhost:27017)
- La extensión Community Server Connectors (para el funcionamiento de Apache Tomcat)
- La extensión de MongoDB for VS Code (para visualizar que sí se estén guardando los datos)

## Proceso:

1. Abrir el proyecto en un IDE (se recomienda usar VS code)
2. Añadir el proyecto a Tomcat. (En caso de ser VS code, se debe añadir Tomcat como server y en “add deployment” agregar el archivo hojadevida.war)  
3. Empezar el servidor (clic -> start)
4. Una vez que Tomcat esté listo, abre la página en el navegador y accede a [http://localhost:8080/hojadevida/](http://localhost:8080/hojadevida/perfil)  
5. Listo\! Ya se debe ver la hoja de vida

**Aclaración:** Si va a realizar cambios al código, dirigase a la pestaña de Maven y dentro de sus comandos seleccione primero clean para asegurarse que la próxima compilación que realice sea nueva. Luego, debe seleccionar deploy.
     
   

## Funcionalidades:

1. El botón “Editar Perfil” te permitirá modificar el nombre, biografía, email, experiencia, banner y foto de perfil, luego haces clic en guardar cambios para que se almacenen en MongoDB 
2. El botón “Agregar Habilidad” te permité ingresar el nombre de una nueva habilidad
3. Los íconos al lado de cada habilidad son para editar y eliminar la habilidad respectiva

Cada que hagas un cambio, recuerda refrescar la página

