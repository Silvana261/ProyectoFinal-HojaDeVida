package com.pagina.Servlets;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/habilidad")
public class HabilidadServidor extends HttpServlet {

    private IGestorHabilidad gestor = new GestorHabilidad();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Listar todas las habilidades
        request.setAttribute("habilidades", gestor.listarHabilidades());
        request.getRequestDispatcher("/vista/habilidades.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String nombre = request.getParameter("nombre");
        String nombreNuevo = request.getParameter("nombreNuevo"); // para editar

        if ("agregar".equals(accion) && nombre != null && !nombre.isEmpty()) {
            Habilidad h = new Habilidad(nombre);
            gestor.agregarHabilidad(h);
        } else if ("editar".equals(accion) && nombre != null && nombreNuevo != null) {
            Habilidad hVieja = new Habilidad(nombre);
            Habilidad hNueva = new Habilidad(nombreNuevo);
            gestor.editarHabilidad(hVieja, hNueva);
        } else if ("eliminar".equals(accion) && nombre != null) {
            Habilidad h = new Habilidad(nombre);
            gestor.eliminarHabilidad(h);
        }

        // Recargar la página para mostrar cambios
        response.sendRedirect("habilidad");
    }
}
