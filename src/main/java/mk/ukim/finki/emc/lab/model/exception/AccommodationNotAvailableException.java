package mk.ukim.finki.emc.lab.model.exception;

public class AccommodationNotAvailableException extends RuntimeException {
    public AccommodationNotAvailableException(Long id) {
        super("Accommodation with id %d is not available.".formatted(id));
    }
}
