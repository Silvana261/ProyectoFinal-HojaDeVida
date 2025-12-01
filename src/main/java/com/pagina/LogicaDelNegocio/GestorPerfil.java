package com.pagina.LogicaDelNegocio;

import com.pagina.Interfaces.IGestorPerfil;
import com.pagina.Interfaces.IRepositorioPerfil;
import com.pagina.Modelos.Perfil;
import com.pagina.Persistencia.PerfilRepositorio;

/**
 * Clase GestorPerfil que implementa la interfaz IGestorPerfil.
 * Esta clase se encarga de gestionar la información de un perfil de usuario,
 * incluyendo la actualización de foto, banner, nombre, bio, experiencia y email.
 */
public class GestorPerfil implements IGestorPerfil {

    private IRepositorioPerfil repositorioPerfil;
     

    /**
     * Constructor por defecto que crea un PerfilRepositorio concreto.
     */
    public GestorPerfil() {
        this.repositorioPerfil = new PerfilRepositorio();
    }


     /**
     * Actualiza la foto de perfil del usuario.
     * @param rutaFotoPerfil Ruta de la imagen que será usada como foto de perfil.
     */
    public boolean actualizarFotoPerfil(String rutaFotoPerfil) {
        if (rutaFotoPerfil == null || !(rutaFotoPerfil.endsWith(".jpg") ||rutaFotoPerfil.endsWith(".jpeg") ||rutaFotoPerfil.endsWith(".png"))) {
            return false;
        }

        Perfil p = repositorioPerfil.obtener();
        p.setFoto(rutaFotoPerfil);
        repositorioPerfil.guardar(p);
        return true;
    }


    /**
     * Edita la biografía del perfil.
     * @param bio Texto de la biografía, máximo 300 caracteres.
     */
    public boolean editarBio(String bio) {
        if (bio == null )
            return false;

        Perfil p = repositorioPerfil.obtener();
        p.setBio(bio);
        repositorioPerfil.guardar(p);
        return true;
    }

    /**
     * Actualiza la imagen del banner del perfil.
     * @param rutaBanner Ruta de la imagen que será usada como banner.
     */
    public boolean editarBanner(String rutaBanner) {
        if (rutaBanner == null ||!(rutaBanner.endsWith(".jpg") || rutaBanner.endsWith(".jpeg") ||rutaBanner.endsWith(".png"))) {
            return false;
        }

        Perfil p = repositorioPerfil.obtener();
        p.setBanner(rutaBanner);
        repositorioPerfil.guardar(p);
        return true;
    }


    /**
     * Edita el nombre del perfil.
     * @param nombre Nuevo nombre del usuario. Debe tener al menos 2 caracteres.
     */
    public boolean editarNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 2)
            return false;

        Perfil p = repositorioPerfil.obtener();
        p.setNombre(nombre.trim());
        repositorioPerfil.guardar(p);
        return true;
    }

     /**
     * Edita la experiencia del usuario en su perfil.
     * @param experiencia Texto de la experiencia, máximo 300 caracteres.
     */

    public boolean editarExperiencia(String experiencia) {
        if (experiencia == null || experiencia.length() > 300)
            return false;

        Perfil p = repositorioPerfil.obtener();
        p.setExperiencia(experiencia);
        repositorioPerfil.guardar(p);
        return true;
    }


    /**
     * Edita el email del perfil.
     * @param email Nuevo correo electrónico. Debe contener '@' y tener al menos 5 caracteres.
     */
    public boolean editarEmail(String email) {
        if (email == null || !email.contains("@") || email.length() < 5)
            return false;

        Perfil p = repositorioPerfil.obtener();
        p.setEmail(email);
        repositorioPerfil.guardar(p);
        return true;
    }

    /**
     * Obtiene el perfil completo del usuario.
     */
    public Perfil obtenerPerfil() {
        return repositorioPerfil.obtener();
    }
}