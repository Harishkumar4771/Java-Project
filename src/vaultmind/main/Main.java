package vaultmind.main;

import vaultmind.service.DatabaseManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n===== VAULTMIND =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                DatabaseManager.addUser(username, password, "user");

            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                String[] user = DatabaseManager.getUser(username);
                if (user != null && user[1].equals(password)) {
                    System.out.println("Login successful! Welcome, " + user[0] + " [" + user[2] + "]");
                } else {
                    System.out.println("Invalid username or password.");
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
            }
        }
        scanner.close();
    }
}