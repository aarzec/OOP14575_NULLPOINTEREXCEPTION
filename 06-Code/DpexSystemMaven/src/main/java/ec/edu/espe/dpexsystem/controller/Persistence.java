package ec.edu.espe.dpexsystem.controller;

/**
 *
 * @author Luis Sagnay
 */
public interface Persistence {
    public void create(Object data, String table);
        
    public void update(String table, Object query, Object newData);
    
    public void delete(String table, Object query);
    
}