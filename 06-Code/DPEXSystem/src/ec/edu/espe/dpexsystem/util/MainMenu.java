package ec.edu.espe.dpexsystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import ec.edu.espe.dpexsystem.model.Constituency;
import ec.edu.espe.dpexsystem.model.ConsularOffice;

import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.model.ElectoralPackage.PackageType;
import ec.edu.espe.dpexsystem.view.DPEXSystem;

public class MainMenu {
    public static void showAdminMenu() {
        final List<String> menuOptions = Arrays.asList("Register a new electoral package",
                "Modify a registered package", "List all countries", "Register a new country", "Assign new roles",
                "Export electoral packages data", "Logout", "Quit");
        final ConsoleMenu menu = new ConsoleMenu("Main Menu - Administrator", menuOptions);

        ConsoleUtil.clearConsole();
        while (true) {
            menu.displayMenu();
            final int choice = menu.getUserChoice();
            ConsoleUtil.clearConsole();
            switch (choice) {
                case 1:
                    registerElectoralPackage();
                    break;
                case 2:
                    modifyPackages();
                    break;
                case 3:
                    printAllCountries();
                    break;
                case 4:
                    registerCountry();
                    break;
                case 5:
                    createNewRole();
                    break;
                case 7:
                    logInNewUser();
                    break;
                case 8:
                    System.out.println("Thanks for using ____");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\t Invalid option. Please choose a valid option. \n");
            }
            ConsoleUtil.consolePause();
        }
    }

    // ! OLD METHOD
    // public static void createPackage(Country country, ConsularOffice consularOffice, PackageType packageType) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Enter the package id: ");
    //     int packageId = scanner.nextInt();
    //     scanner.nextLine();

    //     System.out.print("Enter the status of the package: ");
    //     String status = scanner.nextLine();

    //     System.out.print("Enter the weight of the package (in kg): ");
    //     float weight = scanner.nextFloat();

    //     ElectoralPackage newPackage = new ElectoralPackage(packageId, country, consularOffice, null, status,
    //             packageType, weight);

    //     System.out.println("Package added successfully:");
    //     System.out.println(newPackage.toString());
    // }

    private static void registerElectoralPackage() {
        Country country;
        Constituency constituency;
        float weight;

        
        while (true) {
            final String countryName = UserInput.getString("Enter the country name: ");
            country = DPEXSystem.getCountry(countryName);
            if (country == null) {
                System.out.println("The country you entered doesn't exist");
            }
            break;
        }
        
        while (true) {
            registerConsularOffice();
            break; 
        }
        
        while (true) {
            //registerConstituency();
            break; 
        }
            

        final int ecuadorianPopulation = country.getEcuadorianPopulation();
        PackageType packageType;
        if (ecuadorianPopulation < 100) {
            packageType = PackageType.CNE;
        } else if (ecuadorianPopulation >= 100 && ecuadorianPopulation < 900) {
            packageType = PackageType.MIXTO;
        } else {
            packageType = PackageType.GENERO;
        }

        // System.out.print("Enter the type of the package: "); // le pido ingreso solo para que el porgrama corra
        // String type = scanner.nextLine();

        // return new PackageType(id, type);
        // TODO: TERMINAR INGRESO PAQUETES
    }

    private static void modifyPackages() {

    }

    private static void registerCountry() {
        String countryName = UserInput.getString("Enter the name of the country: ");
        int ecuadorianPopulation = UserInput.getInt("Enter the Ecuadorian population of the country: ", 0);
        DPEXSystem.addCountry(new Country(countryName, ecuadorianPopulation));
    }
    
    private static void registerConsularOffice() {
        String consularOfficeName = UserInput.getString("Enter the name of the consular office: ");
        String consularOfficeAddress = UserInput.getString("Enter the addres of the consular office: ");
        DPEXSystem.addConsularOffice(new ConsularOffice(consularOfficeName, consularOfficeAddress));
    }
    
    /*
    private static void registerConstituency() {
        String ConstutencyName = UserInput.getString("Enter the name of the Constituency: ");
        String ConstituencyCountry = DPEXSystem
        DPEXSystem.addConsularOffice(new ConsularOffice(consularOfficeName, consularOfficeAddress));
    }
    */
        
      //  String 
        
        //el country se pide o se escoje de los agregados?
        
      //  DPEXSystem.addConstituency(new Constituency(constituencyName, country));
    
    
    private static void printAllCountries() {
        for (Country country : DPEXSystem.getAllCountries()) {
            System.out.println(country);
        }
    }

    private static void createNewRole() {
        //
    }

    public static void saveToJson(Package[] packages) {
        Gson gson = new Gson();
        ArrayList<Package> packageList = new ArrayList<>();

        try (FileWriter writer = new FileWriter("package.json")) {
            gson.toJson(packageList, writer);
            System.out.println("Chickens saved to JSON successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }

    private static void logInNewUser() {

        System.out.println("Executing option 5: Log in as a different user");
    }
}
