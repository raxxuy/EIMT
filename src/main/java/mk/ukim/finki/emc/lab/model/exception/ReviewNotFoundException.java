package mk.ukim.finki.emc.lab.model.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super("Review with id %d does not exist.".formatted(id));
    }
}
