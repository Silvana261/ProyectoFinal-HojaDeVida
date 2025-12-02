package com.pagina.Persistencia;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pagina.Interfaces.IRepositorioPerfil;
import com.pagina.Modelos.Habilidad;
import com.pagina.Modelos.Perfil;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio encargado de guardar y cargar los datos del perfil desde MongoDB.
 * La colección se crea automáticamente si no existe e incluye un perfil predeterminado.
 */
public class PerfilRepositorio implements IRepositorioPerfil {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "perfildb";
    private static final String COLLECTION_NAME = "perfil";
    private static final String PERFIL_ID = "perfil_principal"; // ID único del perfil
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    /**
     * Constructor que inicializa la conexión a MongoDB y asegura la existencia del perfil.
     */
    public PerfilRepositorio() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
            crearPerfilSiNoExiste();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un perfil predeterminado básico.
     */
    private Perfil crearPerfilPredeterminado() {
        Perfil perfil = new Perfil();
        
        perfil.setNombre("Silvana Saavedra");
        perfil.setBio("Estudiante de Ingeniería de Sistemas apasionada por el desarrollo de software y la tecnología. Me gusta aprender nuevas herramientas, crear proyectos y seguir mejorando mis habilidades día a día.");
        perfil.setExperiencia("Actualmente estudiante universitaria. No cuento con experiencia laboral formal, pero he desarrollado proyectos académicos y personales relacionados con programación, estructuras de datos y desarrollo web.");
        perfil.setEmail("silvanasaavedra2006@gmail.com"); 
        perfil.setFoto("https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=400&h=400&fit=crop");
        perfil.setBanner("https://images.unsplash.com/photo-1517694712202-14dd9538aa97?w=1200&h=300&fit=crop");

        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(new Habilidad("Programación en Java"));
        habilidades.add(new Habilidad("Desarrollo web básico (HTML,JSP)"));
        habilidades.add(new Habilidad("Fundamentos de bases de datos"));
        habilidades.add(new Habilidad("Estructuras de datos"));
        habilidades.add(new Habilidad("Lógica y resolución de problemas"));

        perfil.setHabilidades(habilidades);

        return perfil;
    }

    /**
     * Crea el perfil en MongoDB si no existe.
     */
    private void crearPerfilSiNoExiste() {
        try {
            Document query = new Document("_id", PERFIL_ID);
            Document perfilDoc = collection.find(query).first();

            if (perfilDoc == null) {
                Perfil predeterminado = crearPerfilPredeterminado();
                guardar(predeterminado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Convierte un objeto Perfil a un Document de MongoDB.
     */
    private Document perfilADocument(Perfil perfil) {
        Document doc = new Document("_id", PERFIL_ID)
            .append("nombre", perfil.getNombre())
            .append("bio", perfil.getBio())
            .append("experiencia", perfil.getExperiencia())
            .append("email", perfil.getEmail())
            .append("foto", perfil.getFoto())
            .append("banner", perfil.getBanner());

        // Convertir lista de habilidades
        List<Document> habilidadesDoc = new ArrayList<>();
        if (perfil.getHabilidades() != null) {
            for (Habilidad h : perfil.getHabilidades()) {
                habilidadesDoc.add(new Document("nombre", h.getNombre()));
            }
        }
        doc.append("habilidades", habilidadesDoc);

        return doc;
    }

    /**
     * Convierte un Document de MongoDB a un objeto Perfil.
     */
    private Perfil documentAPerfil(Document doc) {
        if (doc == null) return null;

        Perfil perfil = new Perfil();
        perfil.setNombre(doc.getString("nombre"));
        perfil.setBio(doc.getString("bio"));
        perfil.setExperiencia(doc.getString("experiencia"));
        perfil.setEmail(doc.getString("email"));
        perfil.setFoto(doc.getString("foto"));
        perfil.setBanner(doc.getString("banner"));

        // Convertir habilidades
        List<Habilidad> habilidades = new ArrayList<>();
        List<Document> habilidadesDoc = (List<Document>) doc.get("habilidades");
        if (habilidadesDoc != null) {
            for (Document hDoc : habilidadesDoc) {
                habilidades.add(new Habilidad(hDoc.getString("nombre")));
            }
        }
        perfil.setHabilidades(habilidades);

        return perfil;
    }

    /**
     * Guarda el perfil en MongoDB.
     * @param perfil Objeto Perfil a guardar
     */
    @Override
    public void guardar(Perfil perfil) {
        try {
            Document query = new Document("_id", PERFIL_ID);
            Document perfilDoc = perfilADocument(perfil);
            
            // Usar replaceOne con upsert para crear o actualizar
            collection.replaceOne(query, perfilDoc, 
                new com.mongodb.client.model.ReplaceOptions().upsert(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el perfil almacenado en MongoDB.
     * Si no existe o hay un error, retorna un Perfil predeterminado.
     * @return Perfil cargado desde MongoDB o un Perfil predeterminado
     */
    @Override
    public Perfil obtener() {
        try {
            Document query = new Document("_id", PERFIL_ID);
            Document perfilDoc = collection.find(query).first();

            if (perfilDoc == null) {
                Perfil predeterminado = crearPerfilPredeterminado();
                guardar(predeterminado);
                return predeterminado;
            }

            Perfil perfil = documentAPerfil(perfilDoc);

            // Validar que el perfil tenga datos importantes
            if (perfil == null || perfil.getNombre() == null) {
                Perfil predeterminado = crearPerfilPredeterminado();
                guardar(predeterminado);
                return predeterminado;
            }

            return perfil;

        } catch (Exception e) {
            e.printStackTrace();
            return crearPerfilPredeterminado();
        }
    }

    /**
     * Cierra la conexión con MongoDB.
     * Debe llamarse cuando ya no se necesite el repositorio.
     */
    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
