package mk.ukim.finki.emc.lab.model.exception;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id) {
        super("Accommodation with id %d does not exist.".formatted(id));
    }
}
