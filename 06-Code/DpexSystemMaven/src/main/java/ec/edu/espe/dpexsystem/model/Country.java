package ec.edu.espe.dpexsystem.model;

import java.util.Scanner;

import org.bson.types.ObjectId;

/**
 *
 * @author NullPointerException
 */
public class Country {
    private ObjectId id;
    private String name;
    private int ecuadorianPopulation;
    private ConsularOffice consularOffice;

    public Country() {
    }

    public Country(String name, int ecuadorianPopulation, ConsularOffice consularOffice) {
        this.name = name;
        this.ecuadorianPopulation = ecuadorianPopulation;
        this.consularOffice = consularOffice;
    }

    public int getEcuadorianPopulation() {
        return ecuadorianPopulation;
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

    public ConsularOffice getConsularOffice() {
        return consularOffice;
    }

    public void setConsularOffice(ConsularOffice consularOffice) {
        this.consularOffice = consularOffice;
    }
}
