package ec.edu.espe.dpexsystem.view;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import ec.edu.espe.dpexsystem.model.ConsularOffice;
import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.model.ElectoralPackage;
import ec.edu.espe.dpexsystem.model.User;
import ec.edu.espe.dpexsystem.util.JsonHandler;
import ec.edu.espe.dpexsystem.util.LoginMenu;
import ec.edu.espe.dpexsystem.util.MainMenu;
import ec.edu.espe.dpexsystem.util.MessageBox;

/**
 *
 * @author NullPointerException
 */
public class DPEXSystem {
    private static ArrayList<Country> allCountries = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<ConsularOffice> consularOffices = new ArrayList<>();
    private static final String COUNTRIES_FILE = "./countries.json";
    private static ArrayList<ElectoralPackage> allPackages = new ArrayList<>();
    private static final String PACKAGES_FILE = "./packages.json";


    private static User currentUser;

    public static void main(String[] args) {
        initFolderStructure();
        loadCountries();
        users = User.loadFromFile();

        currentUser = LoginMenu.showLoginPrompt();
        MainMenu.showMainMenu(currentUser);
    }

    public static void addCountry(Country country) {
        allCountries.add(country);
        saveCountries();
    }

    public static Country getCountry(String countryName) {
        for (Country country : allCountries) {
            if (country.getName().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }

    private static void initFolderStructure() {
        Path dataDirPath = Paths.get("./data");
        if (!Files.exists(dataDirPath)) {
            try {
                Files.createDirectories(dataDirPath);
            } catch (IOException e) {
                MessageBox.error("There was a problem while initializing the folders structure.");
            }
        }
    };

    public static ArrayList<Country> getAllCountries() {
        return allCountries;
    }

    public static void saveCountries() {
        try {
            JsonHandler.writeToJson(COUNTRIES_FILE, allCountries);
        } catch (IOException e) {
            MessageBox.error("An error occured while persisting countries data");
        }
    }

    private static void loadCountries() {
        Type listType = new TypeToken<ArrayList<Country>>() {
        }.getType();
        ArrayList<Country> data = new ArrayList<>();
        try {
            data = JsonHandler.readFromJson(COUNTRIES_FILE, listType);
        } catch (IOException e) {
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

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static ArrayList<ElectoralPackage> getAllPackages() {
        return allPackages;
    }
    
    public static void addElectoralPackage(ElectoralPackage electoralPackage) {
        allPackages.add(electoralPackage);
    }
    
    public static void saveElectoralPackages() {
        try {
            JsonHandler.writeToJson(PACKAGES_FILE, allPackages);
        } catch (IOException e) {
            MessageBox.error("An error occured while persisting packages data");
        }
    }

}
