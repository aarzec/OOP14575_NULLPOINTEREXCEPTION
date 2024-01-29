package ec.edu.espe.dpexsystem.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.dpexsystem.model.Country;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Luis Sagnay
 */
public class CountryConectionMongo {
    private static final String DATA_BASE = "DPEXSystemDB";

    private static MongoClient mongoClient;

    public static MongoClient conectToMongoDB() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create("mongodb+srv://luis:<password>@cluster0.h5n9yna.mongodb.net/?retryWrites=true&w=majority");
            System.out.println("Conected with MongoBD");
        }
        return mongoClient;
    }

    public static List<Country> listCountries() {
        conectToMongoDB();
        MongoDatabase database = mongoClient.getDatabase(DATA_BASE);
        MongoCollection<Document> collection = database.getCollection("Country");

        List<Document> fullTable = collection.find().into(new ArrayList<>());
        List<Country> customersFromDataBase = new ArrayList<>();

        for (Document doc : fullTable) {
            customersFromDataBase.add(new Gson().fromJson(doc.toJson(), Country.class));
        }
        return customersFromDataBase;

    }

    public static void registerCountry(Country country) {
        conectToMongoDB();
        MongoDatabase database = mongoClient.getDatabase(DATA_BASE);
        MongoCollection<Document> collection = database.getCollection("Country");
        Gson gson = new Gson();
        collection.insertOne(Document.parse(gson.toJson(country)));

    }

    public static void editCountry(Country country) {
        conectToMongoDB();
        MongoDatabase database = mongoClient.getDatabase(DATA_BASE);
        MongoCollection<Document> collection = database.getCollection("Country");
        Document filter = new Document("Country Name", country.getName());
        Document updateItem = new Document("$set", new Document()
        .append("Ecuadorian Population", country.getEcuadorianPopulation())
        .append("Consular Office", country.getConsularOffice()));
        
        collection.updateOne(filter, updateItem);
    }
    
    public static void deleteCountry(String countryName ){
        conectToMongoDB();
        MongoDatabase database = mongoClient.getDatabase(DATA_BASE);
        MongoCollection<Document> collection = database.getCollection("Country");
        Document filter = new Document("Country Name", countryName);
        collection.deleteOne(filter);
    }
}
