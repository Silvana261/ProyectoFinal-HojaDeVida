package com.pagina.LogicaDelNegocio;

import com.pagina.Interfaces.IGestorHabilidad;
import com.pagina.Interfaces.IRepositorioHabilidad;
import com.pagina.Persistencia.HabilidadRepositorio;

public class GestorHabilidad implements IGestorHabilidad {
    
    private IRepositorioHabilidad repositorioHabilidad;

    public GestorHabilidad() {
        this.repositorioHabilidad = new HabilidadRepositorio();
    }
}
