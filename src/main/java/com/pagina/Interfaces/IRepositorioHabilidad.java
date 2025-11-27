package com.pagina.Interfaces;
import com.pagina.Modelos.Habilidad;
import java.util.List;

/**
 * Esta interfaz se encarga de la persistencia de las habilidades
 */
public interface IRepositorioHabilidad {

    /**
     * Carga y devuelve la lista de habilidades completa desde el archivo JSON
     * @return la lista de habilidades
     */
    List<Habilidad> obtener();

    /**
     * Guarda la lista de habilidades completa en el archivo JSON
     * @param habilidades la lista de habilidades
     */
    void guardar(List<Habilidad> habilidades);
}