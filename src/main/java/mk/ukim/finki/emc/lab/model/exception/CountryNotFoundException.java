package mk.ukim.finki.emc.lab.model.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super("Country with id %d does not exist.".formatted(id));
    }
}
