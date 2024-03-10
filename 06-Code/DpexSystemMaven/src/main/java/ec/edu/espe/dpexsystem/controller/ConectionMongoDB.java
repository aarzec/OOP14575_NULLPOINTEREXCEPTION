package ec.edu.espe.dpexsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import ec.edu.espe.dpexsystem.utils.Settings;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Luis Sagnay
 */
public class ConectionMongoDB extends DBManager {
    private static ConectionMongoDB instancia; 
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static final CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    private static final CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    private ConectionMongoDB(String URI, String DB) {
        super();
        DBManager.setDataBase(DB);
        DBManager.setURI(URI);
        connect(DBManager.getURI());
    }

    public static synchronized ConectionMongoDB getInstancia(String URI, String DB) {
        if (instancia == null) {
            instancia = new ConectionMongoDB(URI, DB);
        }
        return instancia;
    }

    @Override
    public final void connect(String URI) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(DBManager.getURI());
            database = mongoClient.getDatabase(Settings.DBName).withCodecRegistry(pojoCodecRegistry);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> void create(String collection, T object) {
        System.out.println("Attempting to insert a '" + object.getClass().getSimpleName() + "' object into the '" + collection + "' collection...");
        MongoCollection<T> mongoCollection = database.getCollection(collection, (Class<T>)object.getClass()).withCodecRegistry(pojoCodecRegistry);
        mongoCollection.insertOne(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(String collection, Object query, Object object) {
        System.out.println("Attempting to update a '" + object.getClass().getSimpleName() + "' object into the '" + collection + "' collection...");
        MongoCollection<Document> mongoCollection = database.getCollection(collection).withCodecRegistry(pojoCodecRegistry);
        UpdateResult result = mongoCollection.replaceOne((Document)query, (Document)object);
        System.out.println("Matched count: " + result.getMatchedCount());
        System.out.println("Modified count: " + result.getModifiedCount());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(String collection, Object query) {
        System.out.println("Attempting to delete a '" + query.getClass().getSimpleName() + "' object from the '" + collection + "' collection...");
        MongoCollection<Document> mongoCollection = database.getCollection(collection).withCodecRegistry(pojoCodecRegistry);
        DeleteResult result = mongoCollection.deleteOne((Document)query);
        System.out.println("Deleted count: " + result.getDeletedCount());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> MongoCursor<T> read(String collection, T query) {
        System.out.println("Attempting to read a '" + query.getClass().getSimpleName() + "' object from the '" + collection + "' collection...");
        MongoCollection<T> mongoCollection = database.getCollection(collection, (Class<T>)query.getClass()).withCodecRegistry(pojoCodecRegistry);
        MongoCursor<T> cursor = mongoCollection.find((Document)query).iterator();
        return cursor;
    }

    @Override
    public <T> MongoCursor<T> readAll(String collection, Class<T> clazz) {
        System.out.println("Attempting to read all '" + collection + "' objects from the '" + collection + "' collection...");
        MongoCollection<T> mongoCollection = database.getCollection(collection, clazz).withCodecRegistry(pojoCodecRegistry);
        MongoCursor<T> cursor = mongoCollection.find().iterator();
        System.out.println("Total documents: " + mongoCollection.countDocuments());
        return cursor;
    }

    @Override
    public <T> T readOne(String collection, Document query, Class<T> clazz) {
        System.out.println("Attempting to read a '" + clazz.getSimpleName() + "' object from the '" + collection + "' collection...");
        MongoCollection<T> mongoCollection = database.getCollection(collection, clazz).withCodecRegistry(pojoCodecRegistry);
        T object = mongoCollection.find((Document)query).first();
        return object;
    }
}
