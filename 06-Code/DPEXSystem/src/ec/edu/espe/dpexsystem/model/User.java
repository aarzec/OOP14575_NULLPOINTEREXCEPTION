package ec.edu.espe.dpexsystem.model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.reflect.TypeToken;

import ec.edu.espe.dpexsystem.util.JsonHandler;
import ec.edu.espe.dpexsystem.util.MessageBox;
import ec.edu.espe.dpexsystem.view.DPEXSystem;

/**
 *
 * @author NullPointerException
 */
public class User {

    private final UUID id;
    private String username;
    private String password;
    private UserType type;

    private String firstName;
    private String lastName;

    public static enum UserType {
        ADMINISTRATOR,
        EMPLOYEE
    }

    private static final String SAVE_FILE = "./data/users.json";

    public User(String username, String password, UserType type, String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = encryptPassword(password);
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void addUser(User user) {
        DPEXSystem.users.add(user);
        saveToFile(DPEXSystem.users);
    }

    public static ArrayList<User> loadFromFile() {
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        ArrayList<User> data = new ArrayList<>();

        try {
            data = JsonHandler.readFromJson(SAVE_FILE, listType);
        } catch (IOException e) {
        }

        return data;
    }

    public static void saveToFile(ArrayList<User> users) {
        try {
            JsonHandler.writeToJson(SAVE_FILE, users);
        } catch (IOException e) {
            MessageBox.error("An error occured while persisting users");
        }
    }

    private static String encryptPassword(String source) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : source.toCharArray()) {
            encrypted.append((char) (c + 1));
        }
        return encrypted.toString();
    }

    private String decryptPassword() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            decrypted.append((char) (c - 1));
        }
        return decrypted.toString();
    }

    public static User login(String providedUsername, String providedPassword) {
        for (User user : DPEXSystem.users) {
            if (user.getUsername().equals(providedUsername)) {
                if (user.decryptPassword().equals(providedPassword)) {
                    return user;
                }
                return null;
            }
        }
        return null;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }
}
