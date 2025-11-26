package com.pagina.Persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pagina.Modelos.Perfil;
import com.pagina.Interfaces.IRepositorioPerfil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PerfilRepositorio implements IRepositorioPerfil {

    private static final String ARCHIVO_PERFIL = "perfil.json";
    private Gson gson;

    public PerfilRepositorio() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        try {
            File archivo = new File(ARCHIVO_PERFIL);

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

    @Override
    public void guardar(Perfil perfil) {
        try (FileWriter writer = new FileWriter(ARCHIVO_PERFIL)) {
            gson.toJson(perfil, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Perfil obtener() {
        try (FileReader reader = new FileReader(ARCHIVO_PERFIL)) {
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
