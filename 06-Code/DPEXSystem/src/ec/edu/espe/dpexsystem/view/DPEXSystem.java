package ec.edu.espe.dpexsystem.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.dpexsystem.model.Constituency;
import ec.edu.espe.dpexsystem.model.ConsularOffice;
import java.lang.reflect.Type;

import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.util.JsonHandler;
import ec.edu.espe.dpexsystem.util.MainMenu;
import ec.edu.espe.dpexsystem.util.MessageBox;

/**
 *
 * @author NullPointerException
 */
public class DPEXSystem {

    private static ArrayList<Country> allCountries = new ArrayList<>();
    private static ArrayList<ConsularOffice> consularOffices = new ArrayList<>();
    private static final String COUNTRIES_FILE = "countries.json";

    //Function that allows you to read the name of the country regardless of whether it is uppercase or lowercase
    public static Country getCountryIgnoreCase(String countryName) {
        for (Country country : allCountries) {
            // Comparar el nombre del país sin distinguir entre mayúsculas y minúsculas
            if (country.getName().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Load saved data
        loadCountries();

        // Show Main Menu
        MainMenu.showAdminMenu();
    }

    public static void addCountry(Country country) {
        allCountries.add(country);
        saveCountries();
    }

    public static Country getCountry(String countryName) {
        for (Country country : allCountries) {
            if (country.getName().equals(countryName)) {
                return country;
            }
        }
        return null;
    }

    public static ArrayList<Country> getAllCountries() {
        return allCountries;
    }

    public static void saveCountries() {
        try {
            JsonHandler.writeToJson(COUNTRIES_FILE, allCountries);
        } catch (IOException e) {
            MessageBox.printMessage("An error occured while persisting countries data");
        }
    }

    private static void loadCountries() {
        Type listType = new TypeToken<ArrayList<Country>>() {
        }.getType();
        ArrayList<Country> data = new ArrayList<>();
        try {
            data = JsonHandler.readFromJson(COUNTRIES_FILE, listType);
        } catch (IOException e) {
            e.printStackTrace(); // Manejar adecuadamente las excepciones
        }
        allCountries = data;

    }
    // TODO inicializar un archivo con las consularoffices registradas

    public static void addConsularOffice(ConsularOffice consularOffice) {
        consularOffices.add(consularOffice);
    }

    public static ConsularOffice getConsularOffice(String consularOfficeName) {
        for (ConsularOffice consularOffice : consularOffices) {
            if (consularOffice.getOfficeName().equals(consularOfficeName)) {
                return consularOffice;
            }
        }
        return null;
    }

    /* WIP
    public static Constituency addConstituency (Constituency constituency) {
        
        Constituency newConstituency;
        newConstituency = new Constituency("name", allCountries, consularOffices);
        return newConstituency;       
    }
     */
}
