package ec.edu.espe.dpexsystem.model;

import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Country {
    private String name;
    private int ecuadorianPopulation;

    public Country(String name, int ecuadorianPopulation) {
        this.name = name;
        this.ecuadorianPopulation = ecuadorianPopulation;
    }
    
    

    
    public int getEcuadorianPopulation(){

        return ecuadorianPopulation;
        
    }
}
