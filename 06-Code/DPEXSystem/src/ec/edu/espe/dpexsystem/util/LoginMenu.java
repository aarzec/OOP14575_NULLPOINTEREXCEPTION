package ec.edu.espe.dpexsystem.util;

import java.io.Console;

import ec.edu.espe.dpexsystem.model.User;
import ec.edu.espe.dpexsystem.model.User.UserType;
import ec.edu.espe.dpexsystem.view.DPEXSystem;

public class LoginMenu {
    public static final String DEFAULT_USERNAME = "admin";
    public static final String DEFAULT_PASSWORD = "admin";

    public static User showLoginPrompt() {
        ConsoleUtil.clearConsole();

        if (DPEXSystem.users.isEmpty()) {
            User defaultAccount = new User(DEFAULT_USERNAME, DEFAULT_PASSWORD, UserType.ADMINISTRATOR, "Administrator", "");
            User.addUser(defaultAccount);
            MessageBox.warn(String.format("We have created a default admin account for you. User: '%s' Password: '%s'", DEFAULT_USERNAME, DEFAULT_PASSWORD), false, false);
        }

        final Console console = System.console();
        User loggedInUser;
        while (true) {
            System.out.println(Color.YELLOW + "\nAuthentication");
            System.out.println(Color.YELLOW + "==========================");

            System.out.println(Color.BLUE + "\tPlease enter your credentials below: ");

            String username = console.readLine(Color.YELLOW + "Username: " + Color.RESET);
            String password = new String(console.readPassword(Color.YELLOW + "Password: " + Color.RESET));

            loggedInUser = User.login(username, password);
            if (loggedInUser == null) {
                MessageBox.error("Wrong username or password");
                continue;
            } else {
                MessageBox.info("Logged in successully");
                return loggedInUser;
            }
        }
    }
}
