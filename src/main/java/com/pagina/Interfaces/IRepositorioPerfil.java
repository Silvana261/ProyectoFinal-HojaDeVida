package com.pagina.Interfaces;
import org.bson.Document;

import com.pagina.Modelos.Perfil;

/**
 * Esta interfaz se encarga de la persistencia del perfil
 */
public interface IRepositorioPerfil {

    /**
     * Obtiene el perfil almacenado en MongoDB
     * @return Perfil cargado desde MongoDB o un Perfil predeterminado
     */
    Perfil obtener();

    /**
     * Guarda el perfil en MongoDB
     * @param perfil Objeto Perfil a guardar
     */
    void guardar(Perfil perfil);

    /**
     * Crea un perfil predeterminado básico
     * @return Perfil predeterminado
     */
    public Perfil crearPerfilPredeterminado();

    /**
     * Crea el perfil en MongoDB si no existe
     */
    public void crearPerfilSiNoExiste();

    /**
     * Convierte un objeto Perfil a un Document de MongoDB
     * @param perfil
     * @return Document
     */
    public Document perfilADocument(Perfil perfil);

    /**
     * Convierte un Document de MongoDB a un objeto Perfil
     * @param doc
     * @return Perfil
     */
    public Perfil documentAPerfil(Document doc);

    /**
     * Cierra la conexión con MongoDB
     */
    public void cerrarConexion();
}