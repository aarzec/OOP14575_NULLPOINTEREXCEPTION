package ec.edu.espe.dpexsystem.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Constituency {
    private String name;
    private ArrayList<Country> countries;
    private ArrayList<ConsularOffice> consularOffices;

    public Constituency(String name, ArrayList<Country> countries, ArrayList<ConsularOffice> consularOffices) {
        this.name = name;
        this.countries = countries;
        this.consularOffices = consularOffices;
    }

    public static Country addCountry() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the country: ");
        String countryName = scanner.nextLine();
        
        //int ecuadorianPopulation = Country.getEcuadorianPopulation(); comentado pq no se como implementarle
        
        System.out.print("Enter the Ecuadorian population of the country: ");
        int ecuadorianPopulation = scanner.nextInt();

        return new Country(countryName, ecuadorianPopulation);
    }
    
    public static ConsularOffice addConsularOffice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the consular office: ");
        String officeName = scanner.nextLine();
        System.out.print("Enter the address of the consular office: ");
        String address = scanner.nextLine();

        return new ConsularOffice(officeName, address);
    }
}
