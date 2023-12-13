package ec.edu.espe.dpexsystem.util;

public class MessageBox {
    private static void printMessage(String message, String prefix, String color, boolean pause, boolean clear) {
        String border = color + "\n╔" + "═".repeat(prefix.length() + message.length() + 2) + "╗";
        String coloredMessage = color + "║ " + prefix + Color.RESET + message + color + " ║" + Color.RESET;
        String bottomBorder = color + "╚" + "═".repeat(prefix.length() + message.length() + 2) + "╝\n" + Color.RESET;

        System.out.println(border);
        System.out.println(coloredMessage);
        System.out.println(bottomBorder);

        if (pause) {
            ConsoleUtil.consolePause();
        }
        if (clear) {
            ConsoleUtil.clearConsole();
        }
    }

    public static void info(String message, boolean pause, boolean clear) {
        printMessage(message, "Info: ", Color.BLUE, pause, clear);
    }

    public static void warn(String message, boolean pause, boolean clear) {
        printMessage(message, "Warning: ", Color.YELLOW, pause, clear);
    }

    public static void error(String message, boolean pause, boolean clear) {
        printMessage(message, "Error: ", Color.RED, pause, clear);
    }

    public static void info(String message) {
        info(message, true, true);
    }

    public static void warn(String message) {
        warn(message, true, true);
    }

    public static void error(String message) {
        error(message, true, true);
    }

}
