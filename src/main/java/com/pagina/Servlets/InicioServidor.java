package com.pagina.Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que maneja la URL raíz del proyecto.
 * Cuando el usuario ingresa a:
 *   http://localhost:8080/hojadevida/
 * automáticamente será redirigido al servlet /perfil,
 * el cual carga el objeto Perfil desde el JSON y
 * finalmente muestra index.jsp.
 */
@WebServlet("")
public class InicioServidor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String ruta = request.getParameter("page");

        if (ruta == null || ruta.isEmpty()) {
            response.sendRedirect("perfil");   // Página por defecto
            return;
        }

        switch (ruta) {
            case "perfil":
                response.sendRedirect("perfil");
                break;

            case "habilidades":
                response.sendRedirect("habilidad");
                break;

            case "config":
                response.sendRedirect("configuracion");
                break;

            default:
                response.sendRedirect("perfil"); // En caso de ruta no válida
        }
    }
}

