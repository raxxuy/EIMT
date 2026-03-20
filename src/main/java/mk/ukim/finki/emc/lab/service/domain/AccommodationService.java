package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.domain.Review;

import java.util.List;

public interface AccommodationService {
    Accommodation findById(Long id);

    List<Accommodation> findAll();

    List<Review> findAllReviews(Long id);

    Accommodation create(Accommodation accommodation);

    Accommodation update(Long id, Accommodation accommodation);

    Accommodation deleteById(Long id);

    Accommodation markAsRented(Long id);
}
