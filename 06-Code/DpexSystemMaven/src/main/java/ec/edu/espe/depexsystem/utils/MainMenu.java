package ec.edu.espe.dpexsystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.edu.espe.dpexsystem.model.Constituency;
import ec.edu.espe.dpexsystem.model.ConsularOffice;
import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.model.ElectoralPackage;
import ec.edu.espe.dpexsystem.model.User;
import ec.edu.espe.dpexsystem.model.User.UserType;
import ec.edu.espe.dpexsystem.view.DPEXSystem;

public class MainMenu {
     public static void showMainMenu(User loggedUser) {
        if (loggedUser.getType() == UserType.ADMINISTRATOR) {
            showAdminMenu();
        }
    }
    

    private static void showAdminMenu() {
        final List<String> menuOptions = Arrays.asList("Register a new electoral package",
                "Modify a registered package", "List all countries", "Register a new country", "Assign new roles",
                "Export electoral packages data as json","Export electoral packages data as csv", "Logout", "Quit");
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
                case 6:
                     saveToJson(DPEXSystem.getAllPackages());
                    break;
                case 7:                  
                     saveToCsv(DPEXSystem.getAllPackages());
                     break;                    
                case 8:
                    LogOut();
                    break;
                case 9:
                    System.out.println("Thanks for using the DPEX System");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t Invalid option. Please choose a valid option. \n");
            }
            ConsoleUtil.consolePause();
        }
    }
    
    private static void registerElectoralPackage() {
        Country country;
        Constituency constituency;

        while (true) {
            final String countryName = UserInput.getString("Enter the country name: ");
            country = DPEXSystem.getCountry(countryName);
            if (country == null) {
                System.out.println("The country you entered doesn't exist");
                continue;
            }

            String constituencyName = UserInput.getString("Enter the name of the constituency: ");
            constituency = new Constituency();
            constituency.setName(constituencyName);
            constituency.addCountry(country);

            int ecuadorianPopulation = country.getEcuadorianPopulation();
            ElectoralPackage.PackageType packageType;
            if (ecuadorianPopulation < 100) {
                packageType = ElectoralPackage.PackageType.CNE;
            } else if (ecuadorianPopulation >= 100 && ecuadorianPopulation < 900) {
                packageType = ElectoralPackage.PackageType.MIXTO;
            } else {
                packageType = ElectoralPackage.PackageType.GENERO;
            }

            float weight = UserInput.getFloat("Enter the package's weight: ");
            ElectoralPackage electoralPackage = new ElectoralPackage();
            electoralPackage.setCountry(country);
            electoralPackage.setConstituency(constituency);
            electoralPackage.setPackageType(packageType);
            electoralPackage.setWeight(weight);

            DPEXSystem.addElectoralPackage(electoralPackage);

            System.out.println("Your package has been successfully registered. Package ID: " + electoralPackage.getPackageId());

            break;
        }
    }
    
    private static void modifyPackages() {
        int packageId = UserInput.getInt("Enter the ID of the package you want to modify: ");

        ElectoralPackage selectedPackage = findPackageById(packageId);

        if (selectedPackage == null) {
            System.out.println("Package not found with ID: " + packageId);
            return;
        }

        while (true) {
            final List<String> menuModifyPackage = Arrays.asList("Country",
                    "Weight", "Status", "Exit");
            final ConsoleMenu menu = new ConsoleMenu("Modify Package Menu", menuModifyPackage);

            menu.displayMenu();
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    modifyCountry(selectedPackage);
                    break;
                case 2:
                    modifyWeight(selectedPackage);
                    break;
                case 3:
                    modifyStatus(selectedPackage);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static ElectoralPackage findPackageById(int packageId) {
        for (ElectoralPackage electoralPackage : DPEXSystem.getAllPackages()) {
            if (electoralPackage.getPackageId() == packageId) {
                return electoralPackage;
            }
        }
        return null;
    }

    private static void modifyCountry(ElectoralPackage selectedPackage) {
        String newCountryName = UserInput.getString("Enter the new country for the package: ");
        Country newCountry = DPEXSystem.getCountry(newCountryName);

        if (newCountry == null) {
            System.out.println("The entered country does not exist.");
            return;
        }

        selectedPackage.setCountry(newCountry);
        System.out.println("Country modified successfully.");
    }

    private static void modifyWeight(ElectoralPackage selectedPackage) {
        float newWeight = UserInput.getFloat("Enter the new weight for the package: ");
        selectedPackage.setWeight(newWeight);
        System.out.println("Weight modified successfully.");
    }

    private static void modifyStatus(ElectoralPackage selectedPackage) {
        final List<String> menuModifyStatus = Arrays.asList("PENDING", "SENT", "ARRIVED");
        final ConsoleMenu menu = new ConsoleMenu("Modify Status", menuModifyStatus);

        menu.displayMenu();
        int choice = menu.getUserChoice();

        switch (choice) {
            case 1:
                selectedPackage.setStatus(ElectoralPackage.PackageStatus.PENDING);
                break;
            case 2:
                selectedPackage.setStatus(ElectoralPackage.PackageStatus.SENT);
                break;
            case 3:
                selectedPackage.setStatus(ElectoralPackage.PackageStatus.ARRIVED);
                break;
            default:
                System.out.println("Invalid choice. Setting status to PENDING.");
                selectedPackage.setStatus(ElectoralPackage.PackageStatus.PENDING);
                break;
        }

        System.out.println("Status modified successfully.");
    }
    
    private static void registerCountry() {
        String countryName;
        while (true) {
            countryName = UserInput.getString("Enter the name of the country: ");
            if (DPEXSystem.getCountry(countryName) != null) {
                MessageBox.error("This country is already registered!");
                continue;
            }
            break;
        }
        int ecuadorianPopulation = UserInput.getInt("Enter the Ecuadorian population of the country: ");

        String consularOfficeName = UserInput.getString("Enter the country's consular office name: ");
        String consularOfficeAddr = UserInput.getString("Enter the consular office's address: ");
        ConsularOffice consularOffice = new ConsularOffice(consularOfficeName, consularOfficeAddr);

        DPEXSystem.addCountry(new Country(countryName, ecuadorianPopulation, consularOffice));
        MessageBox.info("Country registered successfully");
    }

    private static void printAllCountries() {
        for (Country country : DPEXSystem.getAllCountries()) {
            System.out.println(country);
        }
    }

    private static void createNewRole() {
        // TO DO
    }

     public static void saveToJson(ArrayList<ElectoralPackage> packages) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("packages.json")) {
            gson.toJson(packages, writer);
            System.out.println("Electoral packages saved to JSON successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    
    }
     
     public static void saveToCsv(ArrayList<ElectoralPackage> packages) {
        String csvFileName = "packages.csv";

        try (FileWriter writer = new FileWriter(csvFileName)) {
 
            writer.write("PackageId,Country,Constituency,PackageType,Weight,Status\n");

            for (ElectoralPackage electoralPackage : packages) {
                writer.write(String.format("%d,%s,%s,%s,%.2f,%s\n",
                        electoralPackage.getPackageId(),
                        electoralPackage.getCountry().getName(),
                        electoralPackage.getConstituency().getName(),
                        electoralPackage.getPackageType(),
                        electoralPackage.getWeight(),
                        electoralPackage.getStatus()));
            }

            System.out.println("Electoral packages saved to CSV successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    private static void logInNewUser() {
        System.out.println("Executing option 6: Log in as a different user");
    }

    private static void LogOut() {
        System.out.println("Logged out succesfuly");
        LoginMenu.showLoginPrompt();
    }

}
