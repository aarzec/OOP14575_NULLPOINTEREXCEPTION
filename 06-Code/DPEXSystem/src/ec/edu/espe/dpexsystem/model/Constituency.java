package ec.edu.espe.dpexsystem.model;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NullPointerException
 */
public class Constituency {
    private String name;
    private List<Country> countries;
    private List<ConsularOffice> consularOffices;

    public Constituency(String name, List<Country> countries, List<ConsularOffice> consularOffices) {
        this.name = name;
        this.countries = countries;
        this.consularOffices = consularOffices;
    }

    public void addCountry(Country country){
        countries.add(country);
    }
    
    public void addConsularOffice(ConsularOffice office){
        consularOffices.add(office);
    }
}
