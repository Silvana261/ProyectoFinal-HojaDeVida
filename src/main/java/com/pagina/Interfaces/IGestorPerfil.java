package com.pagina.Interfaces;
import com.pagina.Modelos.Perfil;

public interface IGestorPerfil {

    /**
     * Acutailiza la foto de perfil
     * @param rutaFoto ruta de la nueva foto
     */
    void actualizarFotoPerfil(String rutaFoto);

    /**
     * Edita la bio del perfil
     * @param bio bio nueva
     */
    void editarBio(String bio);

    /**
     * Edita el banner del perfil
     * @param rutaBanner ruta de el nuevo banner
     */
    void editarBanner(String rutaBanner);

    /**
     * Edita el nombre del perfil
     * @param nombre nombre nuevo del perfil
     */
    void editarNombre(String nombre);

    /**
     * Edita la experiencia del perfil (de la hoja de vida)
     * @param experiencia experiencia nueva del perfil
     */
    void editarExperiencia(String experiencia);

    /**
     * Edita el email del perfil
     * @param email email nuevo
     */
    void editarEmail(String email);

    /**
     * Pide al repositorio IRepositorioPerfil el perfil completo
     * @return el perfil completo
     */
    Perfil obtenerPerfil();
}
