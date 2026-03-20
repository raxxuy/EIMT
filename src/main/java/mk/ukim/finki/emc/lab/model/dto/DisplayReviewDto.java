package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.domain.Review;

import java.util.List;

public record DisplayReviewDto(
        Long id,
        String comment,
        Double rating,
        Long accommodationId
) {
    public static DisplayReviewDto from(Review review) {
        return new DisplayReviewDto(
                review.getId(),
                review.getComment(),
                review.getRating(),
                review.getAccommodation().getId()
        );
    }

    public static List<DisplayReviewDto> from(List<Review> reviews) {
        return reviews
                .stream()
                .map(DisplayReviewDto::from)
                .toList();
    }
}