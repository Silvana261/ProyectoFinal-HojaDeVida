<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pagina.Modelos.Perfil" %>
<%@ page import="com.pagina.Modelos.Habilidad" %>
<%@ page import="com.pagina.Persistencia.RepositorioPerfil" %>
<%@ page import="com.pagina.Persistencia.RepositorioHabilidad" %>

<%
    RepositorioPerfil repoPerfil = new RepositorioPerfil();
    RepositorioHabilidad repoHab = new RepositorioHabilidad();

    Perfil perfil = repoPerfil.obtenerPerfil();
    java.util.List<Habilidad> habilidades = repoHab.obtenerTodas();
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Página Personal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body { background: #bfdbff; }
        .contenedor { max-width: 1100px; }

        /* FOTO DE PERFIL */
        .foto-perfil {
            width: 180px;
            height: 180px;
            border-radius: 50%;
            object-fit: cover;
            border: 5px solid white;
            margin-top: -90px; /* que baje sobre el banner */
        }

        .banner {
            width: 100%;
            height: 250px;
            object-fit: cover;
        }
    </style>
</head>

<body>

<!-- =========================== BANNER =========================== -->
<div class="w-100">
    <img src="img/banner.jpg" class="banner" alt="banner">
</div>

<div class="container contenedor mt-3">

    <div class="text-center">
        <img src="img/perfil.jpg" class="foto-perfil shadow" alt="foto perfil">
        <h2 class="mt-3"><%= perfil.getNombre() %></h2>
        <p class="text-muted"><%= perfil.getDescripcion() %></p>
    </div>

    <!-- =========================== FORMULARIO PERFIL =========================== -->
    <div class="card my-4">
        <div class="card-header bg-primary text-white">
            Editar Perfil
        </div>

        <div class="card-body">
            <form action="PerfilServlet" method="post">
                <div class="mb-3">
                    <label class="form-label">Nombre:</label>
                    <input type="text" name="nombre" class="form-control" value="<%= perfil.getNombre() %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Descripción:</label>
                    <textarea name="descripcion" class="form-control"><%= perfil.getDescripcion() %></textarea>
                </div>

                <button type="submit" class="btn btn-success">Guardar cambios</button>
            </form>
        </div>
    </div>

    <!-- =========================== HABILIDADES =========================== -->
    <div class="card">
        <div class="card-header bg-secondary text-white">
            Habilidades
        </div>

        <div class="card-body">

            <!-- Lista -->
            <ul class="list-group mb-3">
                <% for (Habilidad h : habilidades) { %>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>
                            <strong><%= h.getTitulo() %></strong>
                            <small class="text-muted"> - <%= h.getNivel() %></small>
                        </span>
                    </li>
                <% } %>
            </ul>

            <!-- Formulario -->
            <form action="HabilidadServlet" method="post">
                <div class="mb-3">
                    <label class="form-label">Título habilidad:</label>
                    <input type="text" name="titulo" required class="form-control">
                </div>

                <div class="mb-3">
                    <label class="form-label">Nivel:</label>
                    <input type="text" name="nivel" required class="form-control">
                </div>

                <button type="submit" class="btn btn-primary">Agregar
