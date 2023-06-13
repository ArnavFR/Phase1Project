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

    public static void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to add [please enter the extension of the file as well]: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + File.separator + fileName);

        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file.");
        }

        displayFileOperationsMenu();
    }

    public static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + File.separator + fileName);

        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Unable to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }

        displayFileOperationsMenu();
    }

    public static void searchFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File directory = new File(ROOT_DIRECTORY);
        File[] files = directory.listFiles();

        boolean fileFound = false;
        for (File file : files) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                fileFound = true;
                System.out.println("File found: " + file.getAbsolutePath());
                break;
            }
        }
        if (!fileFound) {
            System.out.println("File not found.");
        }

        displayFileOperationsMenu();
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
            case 1 -> addFile();
            case 2 -> deleteFile();
            case 3 -> searchFile();
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