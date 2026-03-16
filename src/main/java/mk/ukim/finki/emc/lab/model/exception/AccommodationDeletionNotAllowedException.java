package mk.ukim.finki.emc.lab.model.exception;

public class AccommodationDeletionNotAllowedException extends RuntimeException {
    public AccommodationDeletionNotAllowedException(Long id) {
        super("Accommodation with id %d cannot be deleted.".formatted(id));
    }
}
