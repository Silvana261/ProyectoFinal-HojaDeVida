package com.pagina.LogicaDelNegocio;

import com.pagina.Interfaces.IGestorHabilidad;
import com.pagina.Interfaces.IRepositorioPerfil;
import com.pagina.Modelos.Habilidad;
import com.pagina.Modelos.Perfil;
import com.pagina.Persistencia.PerfilRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de habilidades que trabaja directamente con el PerfilRepositorio.
 * Las habilidades están almacenadas dentro del perfil en MongoDB.
 */
public class GestorHabilidad implements IGestorHabilidad {

    private IRepositorioPerfil repositorio = new PerfilRepositorio();

    @Override
    public void agregarHabilidad(Habilidad h) {
        Perfil perfil = repositorio.obtener();
        
        // Inicializar lista si es null
        if (perfil.getHabilidades() == null) {
            perfil.setHabilidades(new ArrayList<>());
        }
        
        perfil.getHabilidades().add(h);
        repositorio.guardar(perfil);
    }

    @Override
    public void eliminarHabilidad(Habilidad h) {
        Perfil perfil = repositorio.obtener();
        
        if (perfil.getHabilidades() != null) {
            perfil.getHabilidades().removeIf(
                item -> item.getNombre() != null && item.getNombre().equals(h.getNombre())
            );
            repositorio.guardar(perfil);
        }
    }

    /**
     * Edita una habilidad existente.
     * @param nombreAntiguo El nombre actual de la habilidad a editar
     * @param nombreNuevo El nuevo nombre para la habilidad
     */
    public void editarHabilidad(String nombreAntiguo, String nombreNuevo) {
        Perfil perfil = repositorio.obtener();
        
        if (perfil.getHabilidades() != null) {
            List<Habilidad> habilidades = perfil.getHabilidades();
            for (int i = 0; i < habilidades.size(); i++) {
                Habilidad actual = habilidades.get(i);
                if (actual.getNombre() != null && actual.getNombre().equals(nombreAntiguo)) {
                    // Actualizar con el nuevo nombre
                    habilidades.set(i, new Habilidad(nombreNuevo));
                    break;
                }
            }
            repositorio.guardar(perfil);
        }
    }
    @Override
    public List<Habilidad> listarHabilidades() {
        Perfil perfil = repositorio.obtener();
        
        if (perfil.getHabilidades() == null) {
            return new ArrayList<>();
        }
        
        return perfil.getHabilidades();
    }
}