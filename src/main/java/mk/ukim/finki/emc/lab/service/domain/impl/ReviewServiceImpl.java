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
        List<Review> reviews = findAllByAccommodationId(accommodationId);
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long id, Review review) {
        Review existing = findById(id);
        existing.setComment(review.getComment());
        existing.setRating(review.getRating());
        existing.setAccommodation(review.getAccommodation());
        return reviewRepository.save(existing);
    }

    @Override
    public Review deleteById(Long id) {
        Review existing = findById(id);
        reviewRepository.delete(existing);
        return existing;
    }
}
