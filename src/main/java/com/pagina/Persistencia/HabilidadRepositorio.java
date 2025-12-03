package com.pagina.Persistencia;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pagina.Interfaces.IRepositorioHabilidad;
import com.pagina.Modelos.Habilidad;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

public class HabilidadRepositorio implements IRepositorioHabilidad {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "perfildb";
    private static final String COLLECTION_NAME = "habilidades";
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public HabilidadRepositorio() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Habilidad> obtener() {
        List<Habilidad> habilidades = new ArrayList<>();
        try {
            for (Document doc : collection.find()) {
                String nombre = doc.getString("nombre");
                Habilidad habilidad = new Habilidad(nombre);
                habilidades.add(habilidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habilidades;
    }

    @Override
    public void guardar(List<Habilidad> lista) {
        try {
            // Limpiar la colección
            collection.deleteMany(new Document());
            
            // Insertar todas las habilidades
            List<Document> documentos = new ArrayList<>();
            for (Habilidad h : lista) {
                Document doc = new Document("nombre", h.getNombre());
                documentos.add(doc);
            }
            
            if (!documentos.isEmpty()) {
                collection.insertMany(documentos);
            }
        } catch (Exception e) {
            e.printStackTrace();
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