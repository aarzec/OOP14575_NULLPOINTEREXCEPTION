package ec.edu.espe.dpexsystem.model;

import java.util.ArrayList;

/**
 *
 * @author NullPointerException
 */
public class Constituency {

    private String name;
    private ArrayList<String> countryNames;

    public Constituency() {
        this.countryNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCountry(String countryName) {
        this.countryNames.add(countryName);
    }

    public ArrayList<String> getCountryNames() {
        return countryNames;
    }
}