package com.pagina.Interfaces;
import com.pagina.Modelos.Perfil;


/**
 * Esta interfaz se encarga de definir las operaciones que se realizan al perfil
 */
public interface IGestorPerfil {

    /**
     * Acutailiza la foto de perfil
     * @param rutaFoto ruta de la nueva foto
     */
    boolean actualizarFotoPerfil(String rutaFoto);

    /**
     * Edita la bio del perfil
     * @param bio bio nueva
     */
    boolean editarBio(String bio);

    /**
     * Edita el banner del perfil
     * @param rutaBanner ruta de el nuevo banner
     */
    boolean editarBanner(String rutaBanner);

    /**
     * Edita el nombre del perfil
     * @param nombre nombre nuevo del perfil
     */
    boolean editarNombre(String nombre);

    /**
     * Edita la experiencia del perfil (de la hoja de vida)
     * @param experiencia experiencia nueva del perfil
     */
    boolean editarExperiencia(String experiencia);

    /**
     * Edita el email del perfil
     * @param email email nuevo
     */
    boolean editarEmail(String email);

    /**
     * Pide al repositorio IRepositorioPerfil el perfil completo
     * @return el perfil completo
     */
    Perfil obtenerPerfil();
}
