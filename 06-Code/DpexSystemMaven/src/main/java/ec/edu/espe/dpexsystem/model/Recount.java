package ec.edu.espe.dpexsystem.model;

import java.util.ArrayList;

/**
 *
 * @author NullPointerException
 */
public class Recount {

    private ArrayList<ElectoralPackage> packages;
    
    public void addPackage(ElectoralPackage packages){
        this.packages.add(packages);
    }
    
    public void getListPackage(ElectoralPackage packages){
        
    }
    
    public void removePackage(ElectoralPackage packages){
        this.packages.remove(packages);
    }
}
