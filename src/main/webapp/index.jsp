<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.pagina.Modelos.Perfil" %>
<%@ page import="com.pagina.Modelos.Habilidad" %>
<%@ page import="java.util.List" %>

<%
    Perfil perfil = (Perfil) request.getAttribute("perfil");
    if (perfil == null) {
        perfil = new Perfil();
        perfil.setNombre("Mi Hoja de Vida");
        perfil.setBio("Profesional dedicado y comprometido con la excelencia");
        perfil.setExperiencia("5 años en desarrollo de software");
        perfil.setEmail("usuario@example.com");
        perfil.setFoto("Imagenes/foto.jpg");
        perfil.setBanner("Imagenes/banner.jpg");
    }
    
    List<Habilidad> habilidades = perfil.getHabilidades();
    if (habilidades == null || habilidades.isEmpty()) {
        habilidades = new java.util.ArrayList<>();
        habilidades.add(new Habilidad("Java"));
        habilidades.add(new Habilidad("SQL"));
        habilidades.add(new Habilidad("HTML/CSS"));
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hoja de Vida - <%= perfil.getNombre() %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        :root {
            --primary: #0d6efd;
            --secondary: #6c757d;
        }
        
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px 0;
        }
        
        .perfil-container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            overflow: hidden;
            margin-bottom: 30px;
        }
        
        .banner {
            width: 100%;
            height: 250px;
            background-size: cover;
            background-position: center;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            position: relative;
        }
        
        .foto-perfil {
            width: 180px;
            height: 180px;
            border-radius: 50%;
            border: 8px solid white;
            margin-top: -90px;
            object-fit: cover;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
            background-color: #e9ecef;
        }
        
        .info-header {
            padding: 20px 30px;
            text-align: center;
        }
        
        .info-header h1 {
            margin: 20px 0 10px;
            color: #2c3e50;
            font-weight: 700;
        }
        
        .info-header p {
            color: #667eea;
            font-size: 16px;
            margin: 5px 0;
        }
        
        .email-info {
            color: #666;
            font-size: 14px;
            margin-top: 10px;
        }
        
        .section {
            padding: 30px;
            border-bottom: 1px solid #e9ecef;
        }
        
        .section:last-child {
            border-bottom: none;
        }
        
        .section-title {
            font-size: 20px;
            font-weight: 600;
            color: #2c3e50;
            margin-bottom: 15px;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        
        .section-title i {
            color: #667eea;
            font-size: 24px;
        }
        
        .bio-text {
            color: #555;
            line-height: 1.6;
            font-size: 15px;
        }
        
        .experiencia-text {
            color: #555;
            line-height: 1.6;
            font-size: 15px;
        }
        
        .habilidades-list {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        
        .skill-badge {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 500;
            display: inline-block;
        }
        
        .botones-accion {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            margin-top: 30px;
            justify-content: center;
        }
        
        .btn-accion {
            padding: 10px 20px;
            border-radius: 8px;
            font-weight: 500;
            transition: all 0.3s ease;
            border: none;
        }
        
        .btn-accion:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
    </style>
</head>

<body>
    <div class="container mt-5" style="max-width: 900px;">
        <div class="perfil-container">
            
            <!-- BANNER -->
            <div class="banner" style="background-image: url('<%= perfil.getBanner() %>');"></div>
            
            <!-- INFO PRINCIPAL -->
            <div class="info-header">
                <img src="<%= perfil.getFoto() %>" class="foto-perfil shadow" alt="Foto de perfil" 
                     onerror="this.src='data:image/svg+xml,%3Csvg xmlns=%22http://www.w3.org/2000/svg%22 width=%22180%22 height=%22180%22%3E%3Ccircle cx=%2290%22 cy=%2290%22 r=%2290%22 fill=%22%23e9ecef%22/%3E%3C/svg%3E'">
                
                <h1><%= perfil.getNombre() %></h1>
                <p class="email-info">
                    <i class="bi bi-envelope"></i> <%= perfil.getEmail() %>
                </p>
            </div>
            
            <!-- BIOGRAFÍA -->
            <div class="section">
                <div class="section-title">
                    <i class="bi bi-person-circle"></i>
                    Acerca de mí
                </div>
                <p class="bio-text"><%= perfil.getBio() %></p>
            </div>
            
            <!-- EXPERIENCIA -->
            <div class="section">
                <div class="section-title">
                    <i class="bi bi-briefcase"></i>
                    Experiencia
                </div>
                <p class="experiencia-text"><%= perfil.getExperiencia() %></p>
            </div>
            
            <!-- HABILIDADES -->
            <div class="section">
                <div class="section-title">
                    <i class="bi bi-star"></i>
                    Habilidades
                </div>
                <div class="habilidades-list">
                    <% if (habilidades != null && !habilidades.isEmpty()) { %>
                        <% for (Habilidad h : habilidades) { %>
                            <span class="skill-badge"><%= h.getNombre() %></span>
                        <% } %>
                    <% } else { %>
                        <p class="text-muted">No hay habilidades registradas</p>
                    <% } %>
                </div>
            </div>
            
            <!-- BOTONES DE ACCIÓN -->
            <div class="section">
                <div class="botones-accion">
                    <button class="btn btn-accion btn-primary" data-bs-toggle="modal" data-bs-target="#editarPerfilModal">
                        <i class="bi bi-pencil"></i> Editar Perfil
                    </button>
                    <button class="btn btn-accion btn-success" data-bs-toggle="modal" data-bs-target="#agregarHabilidadModal">
                        <i class="bi bi-plus-circle"></i> Agregar Habilidad
                    </button>
                </div>
            </div>
            
        </div>
    </div>
    
    <!-- MODAL: Editar Perfil -->
    <div class="modal fade" id="editarPerfilModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Editar Perfil</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="perfil" method="POST">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <input type="hidden" name="accion" value="editarNombre">
                            <input type="text" name="nombre" class="form-control" value="<%= perfil.getNombre() %>" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Biografía</label>
                            <input type="hidden" name="accion" value="editarBio">
                            <textarea name="bio" class="form-control" rows="3"><%= perfil.getBio() %></textarea>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="hidden" name="accion" value="editarEmail">
                            <input type="email" name="email" class="form-control" value="<%= perfil.getEmail() %>" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <!-- MODAL: Agregar Habilidad -->
    <div class="modal fade" id="agregarHabilidadModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Agregar Habilidad</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="habilidad" method="POST">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Nombre de la Habilidad</label>
                            <input type="text" name="nombre" class="form-control" placeholder="Ej: Java, SQL, etc." required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-success">Agregar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

