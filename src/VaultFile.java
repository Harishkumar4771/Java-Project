public class VaultFile {
    private String fileName;
    private String encryptedPath;
    private String owner;         // username of whoever uploaded it

    public VaultFile(String fileName, String encryptedPath, String owner) {
        this.fileName = fileName;
        this.encryptedPath = encryptedPath;
        this.owner = owner;
    }

    // Getters
    public String getFileName() { return fileName; }
    public String getEncryptedPath() { return encryptedPath; }
    public String getOwner() { return owner; }

    // Setters
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setEncryptedPath(String encryptedPath) { this.encryptedPath = encryptedPath; }
    public void setOwner(String owner) { this.owner = owner; }

    public void displayInfo() {
        System.out.println("File: " + fileName + " | Owner: " + owner);
    }
}
