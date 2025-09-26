package davidebraghi.exceptions;


import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID catalogueId) {
        super("Record with ID: " + catalogueId + " was not found, please try again");
    }
}
