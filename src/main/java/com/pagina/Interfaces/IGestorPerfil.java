package com.pagina.Interfaces;
import com.pagina.Modelos.Perfil;

public interface IGestorPerfil {

    void actualizarFotoPerfil(String rutaFoto);

    void editarBio(String bio);

    void editarBanner(String rutaBanner);

    void editarNombre(String nombre);

    void editarExperiencia(String experiencia);

    void editarEmail(String email);

    Perfil obtenerPerfil();
}
