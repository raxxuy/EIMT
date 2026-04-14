package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.Review;

import java.util.List;

public interface ReviewService {
    Review findById(Long id);

    List<Review> findAll();

    List<Review> findAllByAccommodationId(Long accommodationId);

    Double findAverageRatingByAccommodationId(Long accommodationId);
}
