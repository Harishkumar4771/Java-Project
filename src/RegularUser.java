import java.util.List;

public class RegularUser extends User {

    public RegularUser(String username, String passwordHash) {
        super(username, passwordHash);
    }

    // Regular user can only see their own files
    public void viewMyFiles(List<VaultFile> files) {
        System.out.println("=== My Files ===");
        for (VaultFile file : files) {
            if (file.getOwner().equals(getUsername())) {
                file.displayInfo();
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("[USER] " + getUsername());
    }
}