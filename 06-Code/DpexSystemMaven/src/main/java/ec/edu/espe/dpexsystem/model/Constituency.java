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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        this.countries.add(country);
    }

}
