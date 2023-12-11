package ec.edu.espe.dpexsystem.model;

import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Country {
    private String name;
    private int ecuadorianPopulation;
    
    private Scanner scanner = new Scanner(System.in);

    public Country(String name, int ecuadorianPopulation) {
        this.name = name;
        this.ecuadorianPopulation = ecuadorianPopulation;
    }
    
    public int getEcuadorianPopulation(){
        System.out.print("Enter the Ecuadorian population of the country: ");
        int ecuadorianPopulation = getScanner().nextInt();
        return ecuadorianPopulation;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + getName() + ", ecuadorianPopulation=" + getEcuadorianPopulation() + ", scanner=" + getScanner() + '}';
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

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
}
