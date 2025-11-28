<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="Modelos.Perfil" %>
<%
    Perfil perfil = (Perfil) request.getAttribute("perfil");
    if (perfil == null) {
        perfil = new Perfil();
        perfil.setNombre("Nombre del Usuario");
        perfil.setBio("Esta es la biografía del usuario...");
        perfil.setExperiencia("Experiencia profesional del usuario...");
        perfil.setEmail("correo@example.com");
        perfil.setFoto("foto.jpg");
        perfil.setBanner("Imagenes/banner.jpg");
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Perfil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .banner {
            width: 100%;
            height: 200px;
            background-size: cover;
            background-position: center;
            border-radius: 10px;
        }
        .foto-perfil {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            border: 4px solid white;
            margin-top: -75px;
        }
        .card-perfil {
            border-radius: 15px;
        }
    </style>
</head>

<body class="bg-light">
    <div class="container mt-4">
        <div class="card card-perfil shadow-sm p-3">

            <!-- Banner -->
            <div class="banner mb-3" style="background-image: url('<%= perfil.getBanner() %>');"></div>

            <div class="row">
                <div class="col-md-3 text-center">
                    <!-- Foto de perfil -->
                    <img src="<%= perfil.getFoto() %>" class="foto-perfil shadow">
                </div>

                <div class="col-md-6">
                    <!-- Información del usuario -->
                    <h3 class="mb-0"><%= perfil.getNombre() %></h3>
                    <p class="text-muted">Email: <%= perfil.getEmail() %></p>
                    <h6 class="mt-3 fw-bold">Biografía</h6>
                    <p><%= perfil.getBio() %></p>

                    <h6 class="mt-3 fw-bold">Experiencia</h6>
                    <p><%= perfil.getExperiencia() %></p>
                </div>

                <div class="col-md-3">
    <!-- Sección de habilidades y experiencia debajo de la foto -->
    <h6 class="fw-bold mt-4">Habilidades</h6>
    <ul>
        <li>Comunicación</li>
        <li>Trabajo en equipo</li>
        <li>Resolución de problemas</li>
    </ul>

    <h6 class="fw-bold mt-4">Experiencia</h6>
    <ul>
        <li>2 años en desarrollo Java</li>
        <li>1 año en bases de datos</li>
    </ul>
</div>

<!-- Barra lateral estilo menú -->
<div class="mt-4 d-flex flex-column gap-2 p-3 border rounded bg-white shadow-sm" style="max-width: 250px;">
    <a href="editarDescripcion.jsp" class="btn btn-outline-primary w-100">Editar descripción</a>
    <a href="editarHabilidades.jsp" class="btn btn-outline-primary w-100">Editar habilidades</a>
    <a href="editarExperiencia.jsp" class="btn btn-outline-primary w-100">Editar experiencia</a>
    <a href="editarFoto.jsp" class="btn btn-outline-primary w-100">Editar foto</a>
    <a href="editarBanner.jsp" class="btn btn-outline-primary w-100">Editar banner</a>
    <a href="eliminarSeccion.jsp" class="btn btn-outline-danger w-100">Eliminar sección</a>
</div>

</div>
</div>
    </div>
</body>
</html>

