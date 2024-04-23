package Config;

import java.util.Scanner;

// Singleton class
public class Config {
    // Variables
    private static Scanner scanner = null;

    // Create instance
    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
