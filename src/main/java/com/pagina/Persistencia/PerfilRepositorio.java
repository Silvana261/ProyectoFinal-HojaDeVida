package com.pagina.Persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pagina.Modelos.Perfil;
import com.pagina.Interfaces.IRepositorioPerfil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Repositorio encargado de guardar y cargar los datos del perfil desde un archivo JSON.
 * El archivo se crea automáticamente si no existe.
 */
public class PerfilRepositorio implements IRepositorioPerfil {

    private static final String ARCHIVO = "perfil.json";
    private Gson gson;

    /**
     * Constructor que inicializa Gson y asegura la existencia del archivo JSON.
     */
    public PerfilRepositorio() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        crearArchivoSiNoExiste();
    }

    /**
     * Crea el archivo perfil.json si no existe aún.
     * Se inicializa con un objeto JSON vacío.
     */
    private void crearArchivoSiNoExiste() {
        try {
            File archivo = new File(ARCHIVO);

            if (!archivo.exists()) {
                archivo.createNewFile();

                FileWriter writer = new FileWriter(archivo);
                writer.write("{}");      // objeto vacío
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda el perfil en formato JSON dentro del archivo perfil.json.
     * @param perfil Objeto Perfil a guardar
     */
    @Override
    public void guardar(Perfil perfil) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(perfil, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Obtiene el perfil almacenado en perfil.json.
     * Si el archivo está vacío o ocurre un error, retorna un Perfil nuevo.
     * @return Perfil cargado desde el JSON o un Perfil vacío
     */
    @Override
    public Perfil obtener() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            Perfil perfil = gson.fromJson(reader, Perfil.class);

            if (perfil == null) {
                return new Perfil();  
            }

            return perfil;

        } catch (IOException e) {
            e.printStackTrace();
            return new Perfil();
        }
    }
}
