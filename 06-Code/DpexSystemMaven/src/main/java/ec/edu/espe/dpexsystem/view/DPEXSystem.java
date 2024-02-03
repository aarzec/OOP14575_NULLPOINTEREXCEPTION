package ec.edu.espe.dpexsystem.view;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.dpexsystem.model.Constituency;

import ec.edu.espe.dpexsystem.model.ConsularOffice;
import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.model.ElectoralPackage;
import ec.edu.espe.dpexsystem.model.User;
import ec.edu.espe.dpexsystem.utils.JsonHandler;
import ec.edu.espe.dpexsystem.utils.LoginMenu;
import ec.edu.espe.dpexsystem.utils.MainMenu;
import ec.edu.espe.dpexsystem.utils.MessageBox;

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
    private static ArrayList<Constituency> allConstituencies = new ArrayList<>();
    private static final String CONSTITUENCIES_FILE = "./constituencies.json";

    private static User currentUser;

    public static void main(String[] args) {

        initFolderStructure();
        loadCountries();
        loadConstituencies();
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
    }

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
    
    public static void addConstituency(Constituency constituency) {
        allConstituencies.add(constituency);
        saveConstituencies();
    }

    public static Constituency getConstituency(String constituencyName) {
        for (Constituency constituency : allConstituencies) {
            if (constituency.getName().equalsIgnoreCase(constituencyName)) {
                return constituency;
            }
        }
        return null;
    }

    public static ArrayList<Constituency> getAllConstituencies() {
        return allConstituencies;
    }

    public static void saveConstituencies() {
        try {
            JsonHandler.writeToJson(CONSTITUENCIES_FILE, allConstituencies);
        } catch (IOException e) {
            MessageBox.error("An error occurred while persisting constituencies data");
        }
    }
    
    public static void addCountryToConstituency(String countryName, String constituencyName) {
        Constituency constituency = getConstituency(constituencyName);

        if (constituency != null) {
            constituency.addCountry(countryName);
            saveConstituencies();
        }
    }

    private static void loadConstituencies() {
        Type listType = new TypeToken<ArrayList<Constituency>>() {}.getType();
        ArrayList<Constituency> data = new ArrayList<>();
        try {
            data = JsonHandler.readFromJson(CONSTITUENCIES_FILE, listType);
        }catch (IOException e) {
        }
        allConstituencies = data;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }

}
