package vaultmind.exception;

public class EncryptionFailedException extends RuntimeException {
    public EncryptionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
