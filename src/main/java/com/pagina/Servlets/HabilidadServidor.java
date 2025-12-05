package com.pagina.Servlets;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.pagina.Interfaces.IGestorHabilidad;
import com.pagina.LogicaDelNegocio.GestorHabilidad;
import com.pagina.Modelos.Habilidad;

@WebServlet("/habilidades")

public class HabilidadServidor extends HttpServlet {

    private IGestorHabilidad gestor = new GestorHabilidad();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("habilidades", gestor.listarHabilidades());
        request.getRequestDispatcher("perfil").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        String nombre = request.getParameter("nombre");
        String nombreNuevo = request.getParameter("nombreNuevo");

        if ("agregar".equals(accion) && nombre != null && !nombre.isEmpty()) {
            Habilidad h = new Habilidad(nombre);
            gestor.agregarHabilidad(h);

        } else if ("editar".equals(accion) && nombre != null && nombreNuevo != null) {
            gestor.editarHabilidad(nombre, nombreNuevo);

        } else if ("eliminar".equals(accion) && nombre != null) {
            Habilidad h = new Habilidad(nombre);
            gestor.eliminarHabilidad(h);
        }

        // Redirigir al perfil
        response.sendRedirect("perfil");
    }
}