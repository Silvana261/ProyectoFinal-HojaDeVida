package com.pagina.Servlets;
import java.io.IOException;

import com.pagina.Interfaces.IGestorPerfil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PerfilServidor extends HttpServlet {

    private IGestorPerfil gestor = new GestorPerfil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("perfil", gestor.obtenerPerfil());
        request.getRequestDispatcher("/vista/perfil.jsp").forward(request, response);
    }

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
