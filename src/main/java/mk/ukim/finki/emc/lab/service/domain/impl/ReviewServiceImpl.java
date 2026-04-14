package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.Review;
import mk.ukim.finki.emc.lab.model.exception.ReviewNotFoundException;
import mk.ukim.finki.emc.lab.repository.ReviewRepository;
import mk.ukim.finki.emc.lab.service.domain.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository
                .findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllByAccommodationId(Long accommodationId) {
        return reviewRepository.findAllByAccommodationId(accommodationId);
    }

    @Override
    public Double findAverageRatingByAccommodationId(Long accommodationId) {
        return reviewRepository.findAverageRatingByAccommodationId(accommodationId).orElse(0.0);
    }
}
