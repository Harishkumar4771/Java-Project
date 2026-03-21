package vaultmind.main;

import vaultmind.service.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        // Test adding a user
        DatabaseManager.addUser("anhad", "test123", "admin");

        // Test fetching that user
        String[] user = DatabaseManager.getUser("anhad");
        if (user != null) {
            System.out.println("Found user: " + user[0] + " | Role: " + user[2]);
        }
    }
}