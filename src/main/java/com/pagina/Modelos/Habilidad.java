package com.pagina.Modelos;

/**
 * Modelo que representa una habilidad de la persona de la hoja de vida
 */
public class Habilidad {
    private String nombre;


    /**
     * Constructor por defecto vacío
     */
    public Habilidad(){

    }

    /**
     * Constructor para la instancia de una habilidad
     * @param nombre nombre de la habilidad
     */
    public Habilidad(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
