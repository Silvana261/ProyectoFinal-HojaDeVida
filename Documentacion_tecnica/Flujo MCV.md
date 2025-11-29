# Flujo MCV

1. ## El usuario realiza una acción

   Todo comienza cuando el usuario interactúa con la aplicación web a través de su navegador. Por ejemplo, cuando hace clic en Editar perfil o accede a ver su hoja de vida completa. El navegador envía una petición HTTP al servidor Tomcat.

2. ## El controlador recibe la petición

   Los controladores, implementados como servlets en java, actúan como recepcionistas de la aplicación. Recibe la petición HTTP del usuario y analiza que acción debe realizar. Estos son PerfilServidor y HabilidadServidor  
   

3. ## El controlador coordina con el modelo

   Una vez que el controlador entiende lo que el usuario necesita, se comunica con el Modelo. Inconva a las clases de lógica del negocio específicas (GestorPerfil ó GestorHabilidad) para realizar las operaciones requeridas. Le solicita que obtenga, actualice o procese los datos del perfil o habilidades.  
   

4. ## Persistencia de datos

   Los repositorios como RepositorioPerfil y RepositorioHabilidad se encargan de guardar y recuperar la información desde el almacenamiento JSON

5. ## Retorno al controlador

   Los gestores devuelven los resultados procesados al controlador. Por ejemplo, un objeto Perfil con todos sus datos, una confirmación de que la operación fue exitosa o de que salió mal.

6. ## Preparación para la vista

   El controlador toma los datos y los preparapara ser mostrados  
   

7. ## La vista renderiza la respuesta

   Los JSP, reciben los datos del controlador y se encarga de mostrarlos de forma atractiva al usuario implementando estilos css.  
   

8. ## Respuesta al usuario

   Finalmente, el HTML generado por la vista se envía de vuelta al navegador del usuario a través del servidor Tomcat. El usuario ya puede ver la página actualizada  
     
     
   

