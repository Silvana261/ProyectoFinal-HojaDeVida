package com.pagina.LogicaDelNegocio;

import com.pagina.Interfaces.IGestorHabilidad;
import com.pagina.Modelos.Habilidad;
import com.pagina.Persistencia.HabilidadRepositorio;
import java.util.List;

public class GestorHabilidad implements IGestorHabilidad {

	private HabilidadRepositorio repositorio = new HabilidadRepositorio();

	@Override
	public void agregarHabilidad(Habilidad h) {
		List<Habilidad> lista = repositorio.obtener();
		lista.add(h);
		repositorio.guardar(lista);
	}

	@Override
	public void eliminarHabilidad(Habilidad h) {
		List<Habilidad> lista = repositorio.obtener();
		lista.removeIf(item -> item.getNombre() != null && item.getNombre().equals(h.getNombre()));
		repositorio.guardar(lista);
	}

	@Override
	public void editarHabilidad(Habilidad h) {
		List<Habilidad> lista = repositorio.obtener();
		for (int i = 0; i < lista.size(); i++) {
			Habilidad actual = lista.get(i);
			if (actual.getNombre() != null && actual.getNombre().equals(h.getNombre())) {
				lista.set(i, h);
				break;
			}
		}
		repositorio.guardar(lista);
	}

	@Override
	public List<Habilidad> listarHabilidades() {
		return repositorio.obtener();
	}
}
