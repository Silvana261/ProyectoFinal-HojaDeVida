package com.pagina.Servlets;
import java.io.IOException;
import com.pagina.Interfaces.IGestorHabilidad;
import com.pagina.LogicaDelNegocio.GestorHabilidad;
import com.pagina.Modelos.Habilidad;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet asociado a la URL /habilidad.
 * La anotación @WebServlet("/habilidad") registra este servlet para que
 * cualquier petición a esa ruta sea manejada por esta clase.
 */
@WebServlet("/habilidades")


/**
 * Servlet que maneja las operaciones relacionadas con las habilidades del único perfil.
 * Este servlet utiliza un IGestorHabilidad para interactuar con la lógica de negocio
 * de las habilidades, incluyendo el agregar, eliminar y editar una habilidad, así como listar las habilidades
 */
public class HabilidadServidor extends HttpServlet {

    // Gestor de habilidad que contiene la lógica de negocio y persistencia
    private IGestorHabilidad gestor = new GestorHabilidad();


    /**
     * Maneja las solicitudes GET al servlet.
     * Obtiene las habilidades mediante el gestor y lo coloca como atributo
     * en la solicitud, luego redirige a la vista JSP para mostrar los datos.
     * @param request  Objeto HttpServletRequest que contiene la información de la solicitud
     * @param response Objeto HttpServletResponse para enviar la respuesta al cliente
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Listar todas las habilidades
        request.setAttribute("habilidades", gestor.listarHabilidades());
        request.getRequestDispatcher("habilidades").forward(request, response);
    }


    /**
     * Maneja las solicitudes POST al servlet.
     * Este método recibe un parámetro "accion" que determina qué atributo de las habilidades
     * se debe modificar, y luego llama al método correspondiente del gestor.
     * Finalmente, redirige a la misma página para reflejar los cambios.
     * @param request  Objeto HttpServletRequest que contiene la información de la solicitud
     * @param response Objeto HttpServletResponse para enviar la respuesta al cliente
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String nombre = request.getParameter("nombre");
        String nombreNuevo = request.getParameter("nombreNuevo");

        if ("agregar".equals(accion) && nombre != null && !nombre.isEmpty()) {
            Habilidad h = new Habilidad(nombre);
            gestor.agregarHabilidad(h);

        } else if ("editar".equals(accion) && nombre != null && nombreNuevo != null) {
            // Envía el nombre actual (nombre viejo) y el nuevo nombre al gestor
            gestor.editarHabilidad(nombre, nombreNuevo);

        } else if ("eliminar".equals(accion) && nombre != null) {
            Habilidad h = new Habilidad(nombre);
            gestor.eliminarHabilidad(h);
        }


        // Después de cualquier cambio, recargar la página
        response.sendRedirect("perfil");
    }
}
