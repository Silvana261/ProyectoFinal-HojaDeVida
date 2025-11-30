package com.pagina.Persistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pagina.Modelos.Habilidad;
import com.pagina.Interfaces.IRepositorioHabilidad;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HabilidadRepositorio implements IRepositorioHabilidad {

    private static final String ARCHIVO_HABILIDADES = "habilidades.json";
    private Gson gson;
    private Type tipoLista = new TypeToken<List<Habilidad>>() {}.getType();

    public HabilidadRepositorio() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        try {
            File archivo = new File(ARCHIVO_HABILIDADES);

            if (!archivo.exists()) {
                archivo.createNewFile();

                FileWriter writer = new FileWriter(archivo);
                writer.write("[]");      // lista vacía
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Habilidad> obtener() {
        try (FileReader reader = new FileReader(ARCHIVO_HABILIDADES)) {
            List<Habilidad> lista = gson.fromJson(reader, tipoLista);

            if (lista == null) return new ArrayList<>();

            return lista;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void guardar(List<Habilidad> lista) {
        try (FileWriter writer = new FileWriter(ARCHIVO_HABILIDADES)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
