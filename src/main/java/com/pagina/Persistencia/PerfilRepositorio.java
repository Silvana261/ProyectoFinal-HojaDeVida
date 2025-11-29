package com.pagina.Persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pagina.Modelos.Habilidad;
import com.pagina.Modelos.Perfil;
import com.pagina.Interfaces.IRepositorioPerfil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Repositorio encargado de guardar y cargar los datos del perfil desde un archivo JSON.
 * El archivo se crea automáticamente si no existe e incluye un perfil predeterminado.
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
     * Crea un perfil predeterminado básico.
     * Ajusta los atributos según tu clase Perfil.
     */
    private Perfil crearPerfilPredeterminado() {
        Perfil perfil = new Perfil();

        
        perfil.setNombre("Silvana Saavedra");
        perfil.setBio("Estudiante de Ingeniería de Sistemas apasionada por el desarrollo de software y la tecnología. Me gusta aprender nuevas herramientas, crear proyectos y seguir mejorando mis habilidades día a día.");
        perfil.setExperiencia("Actualmente estudiante universitaria. No cuento con experiencia laboral formal, pero he desarrollado proyectos académicos y personales relacionados con programación, estructuras de datos y desarrollo web.");
        perfil.setEmail("silvanasaavedra2006@gmail.com"); 
        perfil.setFoto("/foto.jpg");
        perfil.setBanner("img/banner_default.png");

       
         List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(new Habilidad("Programación en Java"));
        habilidades.add(new Habilidad("Desarrollo web básico (HTML,JSP)"));
        habilidades.add(new Habilidad("Fundamentos de bases de datos "));
        habilidades.add(new Habilidad("Estructuras de datos"));
        habilidades.add(new Habilidad("Lógica y resolución de problemas"));

        perfil.setHabilidades(habilidades);

        return perfil;
    }


    /**
     * Crea el archivo perfil.json si no existe aún.
     * Se inicializa con un perfil predeterminado.
     */
    private void crearArchivoSiNoExiste() {
        try {
            File archivo = new File(ARCHIVO);

            if (!archivo.exists()) {
                archivo.createNewFile();

                // Guardar un perfil predeterminado
                Perfil predeterminado = crearPerfilPredeterminado();

                try (FileWriter writer = new FileWriter(archivo)) {
                    gson.toJson(predeterminado, writer);
                }
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
     * Si el archivo está vacío, incompleto o ocurre un error, retorna un Perfil predeterminado.
     * @return Perfil cargado desde el JSON o un Perfil predeterminado
     */
    @Override
    public Perfil obtener() {
        try (FileReader reader = new FileReader(ARCHIVO)) {

            Perfil perfil = gson.fromJson(reader, Perfil.class);

            // Si está vacío o no tiene campos importantes, regenerar
            if (perfil == null || perfil.getNombre() == null) {
                Perfil predeterminado = crearPerfilPredeterminado();
                guardar(predeterminado);
                return predeterminado;
            }

            return perfil;

        } catch (IOException e) {
            e.printStackTrace();
            return crearPerfilPredeterminado();
        }
    }
}

