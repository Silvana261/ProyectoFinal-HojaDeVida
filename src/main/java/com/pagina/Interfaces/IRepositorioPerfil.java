package com.pagina.Interfaces;
import com.pagina.Modelos.Perfil;

/**
 * Esta interfaz se encarga de la persistencia del perfil
 */
public interface IRepositorioPerfil {

    /**
     * Carga y devuelve el perfil completo desde el archivo JSON
     * @return el perfil completo
     */
    Perfil obtener();

    /**
     * Guarda el perfil completo en el archivo JSON
     * @param perfil el perfil completo
     */
    void guardar(Perfil perfil);
}