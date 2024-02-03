package ec.edu.espe.dpexsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

/**
 *
 * @author Luis Sagnay
 */
public class ConectionMongoDB extends DBManager{
    private static MongoClient mongoClient;

    public ConectionMongoDB(String URI, String DB) {
        DBManager.setDataBase(DB);
        DBManager.setURI(URI);
        connect(DBManager.getURI());
    }

    @Override
    public final void connect(String URI) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(DBManager.getURI());
        }
    }

    @Override
    public void create(Object data, String table) {
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection(table);
        Gson gson = new Gson();
        collection.insertOne(Document.parse(gson.toJson(data)));
    }

     @Override
    public void update(String table, Object query, Object newData) {
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection(table);

        Gson gson = new Gson();
        Document filterDocument = Document.parse(gson.toJson(query));
        Document updateDocument = Document.parse(gson.toJson(newData));

        UpdateResult result = collection.updateOne(filterDocument, new Document("$set", updateDocument));
    }

    @Override
    public void delete(String table, Object query) {
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection(table);

        Gson gson = new Gson();
        Document filterDocument = Document.parse(gson.toJson(query));

        DeleteResult result = collection.deleteOne(filterDocument);
    }
}