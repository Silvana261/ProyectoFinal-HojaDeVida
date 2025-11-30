package com.pagina.Servlets;
import java.io.IOException;
import com.pagina.Interfaces.IGestorPerfil;
import com.pagina.LogicaDelNegocio.GestorPerfil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet asociado a la URL /perfil.
 * La anotación @WebServlet("/perfil") registra este servlet para que
 * cualquier petición a esa ruta sea manejada por esta clase.
 */
@WebServlet("/perfil")

/**
 * Servlet que maneja las operaciones relacionadas con el perfil único de la aplicación.
 * Este servlet utiliza un IGestorPerfil para interactuar con la lógica de negocio
 * del perfil, incluyendo la edición de nombre, bio, banner, foto, experiencia y email.
 */
public class PerfilServidor extends HttpServlet {

    
   
    private IGestorPerfil gestor = new GestorPerfil();


     /**
     * Maneja las solicitudes GET al servlet.
     * Obtiene el perfil actual mediante el gestor y lo coloca como atributo
     * en la solicitud, luego redirige a la vista JSP para mostrar los datos.
     * @param request  Objeto HttpServletRequest que contiene la información de la solicitud
     * @param response Objeto HttpServletResponse para enviar la respuesta al cliente
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("perfil", gestor.obtenerPerfil());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


     /**
     * Maneja las solicitudes POST al servlet.
     * Este método recibe un parámetro "accion" que determina qué atributo del perfil
     * se debe modificar, y luego llama al método correspondiente del gestor.
     * Finalmente, redirige a la misma página para reflejar los cambios.
     * @param request  Objeto HttpServletRequest que contiene la información de la solicitud
     * @param response Objeto HttpServletResponse para enviar la respuesta al cliente
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "editarNombre":
                gestor.editarNombre(request.getParameter("nombre"));
                break;
            case "editarBio":
                gestor.editarBio(request.getParameter("bio"));
                break;
            case "editarBanner":
                gestor.editarBanner(request.getParameter("banner"));
                break;
            case "editarFoto":
                gestor.actualizarFotoPerfil(request.getParameter("fotoPerfil"));
                break;
            case "editarExperiencia":
                gestor.editarExperiencia(request.getParameter("experiencia"));
                break;
            case "editarEmail":
                gestor.editarEmail(request.getParameter("email"));
                break;
        }

        // Después de cualquier cambio, recargar la página
        response.sendRedirect("perfil");
    }
}
