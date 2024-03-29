package ec.edu.espe.dpexsystem.controller;

import java.util.Iterator;

import org.bson.Document;

/**
 *
 * @author Luis Sagnay
 */
public interface IPersistence {
    public <T> void create(String collection, T object);

    public <T> void update(String collection, T query, T object);
    
    public <T> void delete(String collection, T query);
    
    public <T> Iterator<T> read(String collection, T query);
    public <T> Iterator<T> readAll(String collection, Class<T> clazz);
    public <T> T readOne(String collection, Document query, Class<T> clazz);
}