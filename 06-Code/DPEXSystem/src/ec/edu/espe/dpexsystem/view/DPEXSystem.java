package ec.edu.espe.dpexsystem.view;

import ec.edu.espe.dpexsystem.model.Package;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Luis Sagnay
 */
public class DPEXSystem {
    public static void main(String[] args) {
        
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
}
