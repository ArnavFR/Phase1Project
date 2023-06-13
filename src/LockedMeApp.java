import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeApp {
    private static final String ROOT_DIRECTORY = "./Files";

    public static void displayFileNamesAscending() {
        File directory = new File(ROOT_DIRECTORY);
        File[] files = directory.listFiles();
        assert files != null;
        Arrays.sort(files);

        if (files.length == 0) {
            System.out.println("The directory is empty.");
        } else {
            System.out.println("Current file names in ascending order:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
        System.out.println();

        displayOptions();
    }

    public static void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> displayFileNamesAscending();
            case 2 -> displayFileOperationsMenu();
            case 3 -> {
                System.out.println("Closing the application...");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid option. Please try again.");
                handleUserInput();
            }
        }
    }

    public static void displayOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. View current file names in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Close the application");
        handleUserInput();
    }

    public static void handleFileOperationsInput() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> System.out.println("addFile()");
            case 2 -> System.out.println("deleteFile()");
            case 3 -> System.out.println("searchFile()");
            case 4 -> displayOptions();
            default -> {
                System.out.println("Invalid option. Please try again.");
                handleFileOperationsInput();
            }
        }
    }

    public static void displayFileOperationsMenu() {
        System.out.println("\nFile Operations:");
        System.out.println("1. Add a file to the directory");
        System.out.println("2. Delete a file from the directory");
        System.out.println("3. Search for a file in the directory");
        System.out.println("4. Go back to the main menu");

        handleFileOperationsInput();
    }

    public static void displayWelcomeScreen() {
        System.out.println("Welcome to LockedMeApp!");
        System.out.println("Developed By: Arnav Gupta\n");
        displayOptions();
    }

    public static void main(String[] args) {
        displayWelcomeScreen();
    }
}