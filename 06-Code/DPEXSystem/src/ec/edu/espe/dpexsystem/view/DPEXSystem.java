package ec.edu.espe.dpexsystem.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
    private static final String COUNTRIES_FILE = "countries.json";

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
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(COUNTRIES_FILE)) {
            gson.toJson(allCountries, writer);
        } catch (IOException e) {
            MessageBox.printMessage("An error occured while persisting countries data");
        }
        // try {
        //     JsonHandler.writeToJson(COUNTRIES_FILE, allCountries);
        // } catch (IOException e){
        //     MessageBox.printMessage("An error occured while persisting countries data");
        // }
    }

    private static void loadCountries() {
        Type listType = new TypeToken<ArrayList<Country>>(){}.getType();
        ArrayList<Country> data = new ArrayList<>();
        try {
            data = JsonHandler.readFromJson(COUNTRIES_FILE, listType);
        } catch (IOException e) {}
        allCountries = data;
    }
}
