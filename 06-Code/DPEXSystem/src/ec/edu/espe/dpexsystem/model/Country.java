package ec.edu.espe.dpexsystem.model;

import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Country {
    private String name;
    private int ecuadorianPopulation;

    public int getEcuadorianPopulation() {
        return ecuadorianPopulation;
    }

    public Country(String name, int ecuadorianPopulation) {
        this.name = name;
        this.ecuadorianPopulation = ecuadorianPopulation;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param ecuadorianPopulation the ecuadorianPopulation to set
     */
    public void setEcuadorianPopulation(int ecuadorianPopulation) {
        this.ecuadorianPopulation = ecuadorianPopulation;
    }

    @Override
    public String toString() {
        return "-> " + name + ": Ecuadorian population: " + ecuadorianPopulation;
    }
}
