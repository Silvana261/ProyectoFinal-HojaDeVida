package com.pagina.Interfaces;
import com.pagina.Modelos.Habilidad;
import java.util.List;


public interface IRepositorioHabilidad {
    
    List<Habilidad> obtener();
    void guardar(List<Habilidad> habilidades);
}