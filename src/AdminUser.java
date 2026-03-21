import java.util.List;

public class AdminUser extends User {

    public AdminUser(String username, String passwordHash) {
        super(username, passwordHash);
    }

    // Admin-only method — Sir will ask about this in viva
    public void viewAllUsers(List<User> users) {
        System.out.println("=== All Registered Users ===");
        for (User u : users) {
            u.displayInfo();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("[ADMIN] " + getUsername());
    }
}