package com.pagina;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class Servelets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hola, servlet funcionando!</h1>");
    }
}