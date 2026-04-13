package mk.ukim.finki.emc.lab.service.application.impl;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayReviewDto;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import mk.ukim.finki.emc.lab.service.domain.HostService;
import mk.ukim.finki.emc.lab.service.domain.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;
    private final ReviewService reviewService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService, ReviewService reviewService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
        this.reviewService = reviewService;
    }

    @Override
    public DisplayAccommodationDto findById(Long id) {
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodationService.findById(id), averageRating);
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll(), reviewService::findAverageRatingByAccommodationId);
    }

    @Override
    public List<DisplayReviewDto> findAllReviews(Long id) {
        return DisplayReviewDto.from(reviewService.findAllByAccommodationId(id));
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId());
        Accommodation accommodation = accommodationService.create(createAccommodationDto.toAccommodation(host));
        Double averageRating = reviewService.findAverageRatingByAccommodationId(accommodation.getId());
        return DisplayAccommodationDto.from(accommodation, averageRating);
    }

    @Override
    public DisplayAccommodationDto update(Long id, CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId());
        Accommodation accommodation = accommodationService.update(id, createAccommodationDto.toAccommodation(host));
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodation, averageRating);
    }

    @Override
    public DisplayAccommodationDto deleteById(Long id) {
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodationService.deleteById(id), averageRating);
    }

    @Override
    public DisplayAccommodationDto markAsRented(Long id) {
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodationService.markAsRented(id), averageRating);
    }
}
