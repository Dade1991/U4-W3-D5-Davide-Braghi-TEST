package davidebraghi.exceptions;

import com.github.ladutsko.isbn.ISBN;

public class NotFoundException extends RuntimeException {
    public NotFoundException(ISBN id) {
        super("Record with ID: " + id + " was not found, please try again");
    }
}
