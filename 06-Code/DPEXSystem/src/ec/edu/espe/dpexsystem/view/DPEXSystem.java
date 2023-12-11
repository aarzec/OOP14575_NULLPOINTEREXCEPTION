package ec.edu.espe.dpexsystem.view;

import ec.edu.espe.dpexsystem.model.Package;
import com.google.gson.Gson;
import ec.edu.espe.dpexsystem.model.Constituency;
import ec.edu.espe.dpexsystem.model.ConsularOffice;
import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.model.PackageType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author NullPointerException
 */
public class DPEXSystem {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Country country = Constituency.addCountry();
        ConsularOffice consularOffice = Constituency.addConsularOffice();
        PackageType packageType = createPackageType();

        createPackage(country, consularOffice, packageType);
    }

    public static void createPackage(Country country, ConsularOffice consularOffice, PackageType packageType) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the package id: ");
        int packageId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the status of the package: ");
        String status = scanner.nextLine();

        System.out.print("Enter the weight of the package (in kg): ");
        float weight = scanner.nextFloat();

        Package newPackage = new Package(packageId, country, consularOffice, null, status, packageType, weight);

        System.out.println("Package added successfully:");
        System.out.println(newPackage.toString());
    }

    public static PackageType createPackageType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the id of the package type: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        //if (ecuadorianPopulation <= 100) {
        //    type = "Cne";
        //} else if (ecuadorianPopulation > 100 && ecuadorianPopulation < 900) {
        //    type = "Mixto";
        //} else {
        //   type = "Gender";
        //}
        
        System.out.print("Enter the type of the package: "); //le pido ingreso solo para que el porgrama corra 
        String type = scanner.nextLine();

        return new PackageType(id, type);
    }

    
    public static void saveToJson(Package packages) {
        Gson gson = new Gson();
        ArrayList<Package> packageList = new ArrayList<>();

        try (FileWriter writer = new FileWriter("package.json")) {
            gson.toJson(packageList, writer);
            System.out.println("Chickens saved to JSON successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }
}
