import java.util.ArrayList;
import java.util.List;

public class TestHarman {
    public static void main(String[] args) {

        // Create users
        RegularUser user1 = new RegularUser("alice", "hash123");
        RegularUser user2 = new RegularUser("bob", "hash456");
        AdminUser admin = new AdminUser("admin", "adminHash");

        // Create some files
        VaultFile f1 = new VaultFile("report.pdf", "/vault/enc_report.pdf", "alice");
        VaultFile f2 = new VaultFile("notes.txt", "/vault/enc_notes.txt", "bob");
        VaultFile f3 = new VaultFile("contract.pdf", "/vault/enc_contract.pdf", "alice");

        // Test displayInfo (polymorphism in action)
        user1.displayInfo();
        user2.displayInfo();
        admin.displayInfo();

        // Test viewMyFiles
        List<VaultFile> allFiles = new ArrayList<>();
        allFiles.add(f1);
        allFiles.add(f2);
        allFiles.add(f3);

        System.out.println("\n--- Alice's files ---");
        user1.viewMyFiles(allFiles);

        // Test admin viewing all users
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(admin);

        System.out.println("\n--- Admin view ---");
        admin.viewAllUsers(allUsers);
    }
}
