package com.pagina.Interfaces;
import com.pagina.Modelos.Habilidad;
import java.util.List;

/**
 * Esta interfaz se encarga de las operaciones que se realizan sobre las habilidades
 */
public interface IGestorHabilidad {

    /**
     * Agrega una nueva habilidad al gestor.
     * @param h la habilidad a agregar
     */
    void agregarHabilidad(Habilidad h);

    /**
     * Elimina una habilidad existente del gestor.
     * @param h la habilidad a eliminar
     */
    void eliminarHabilidad(Habilidad h);

    /**
     * Edita una habilidad existente.
     * @param h la habilidad con los nuevos datos
     */
    void editarHabilidad(nombreAntiguo,nombreNuevo);

    /**
     * Retorna la lista de todas las habilidades.
     * @return lista de habilidades
     */
    List<Habilidad> listarHabilidades();
}
