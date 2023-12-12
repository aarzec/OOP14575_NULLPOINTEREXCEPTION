package ec.edu.espe.dpexsystem.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Storage {

    private ArrayList<ElectoralPackage> packages = new ArrayList<>();
    
    
    public void addPackage(ElectoralPackage packages){
        this.packages.add(packages);
    }
    
    public void removePackage(ElectoralPackage packages){
        this.packages.remove(packages);
    }
    
    public ElectoralPackage[] getPackage(){
        
        return null;
        
    }
}
