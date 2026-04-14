package mk.ukim.finki.emc.lab.service.application.impl;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayReviewDto;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;
import mk.ukim.finki.emc.lab.model.view.AccommodationView;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import mk.ukim.finki.emc.lab.service.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final AccommodationViewService accommodationViewService;
    private final AccommodationStatsViewService accommodationStatsViewService;
    private final AccommodationActivityLogService accommodationActivityLogService;
    private final HostService hostService;
    private final ReviewService reviewService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, AccommodationViewService accommodationViewService, AccommodationStatsViewService accommodationStatsViewService, AccommodationActivityLogService accommodationActivityLogService, HostService hostService, ReviewService reviewService) {
        this.accommodationService = accommodationService;
        this.accommodationViewService = accommodationViewService;
        this.accommodationStatsViewService = accommodationStatsViewService;
        this.accommodationActivityLogService = accommodationActivityLogService;
        this.hostService = hostService;
        this.reviewService = reviewService;
    }

    @Override
    public DisplayAccommodationDto findById(Long id) {
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodationService.findById(id), averageRating);
    }

    @Override
    public DisplayAccommodationDto findWithHostAndCountryById(Long id) {
        Double averageRating = reviewService.findAverageRatingByAccommodationId(id);
        return DisplayAccommodationDto.from(accommodationService.findWithHostAndCountryById(id), averageRating);
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll(), reviewService::findAverageRatingByAccommodationId);
    }

    @Override
    public Page<DisplayAccommodationDto> findAll(FilterAccommodationDto filter, int page, int size, String sortBy) {
        return accommodationService
                .findAll(filter, page, size, sortBy)
                .map(a -> DisplayAccommodationDto.from(
                        a,
                        reviewService.findAverageRatingByAccommodationId(a.getId())
                ));
    }

    @Override
    public Page<AccommodationActivityLog> findAllActivityLogs(int page, int size, String sortBy) {
        return accommodationActivityLogService.findAll(page, size, sortBy);
    }

    @Override
    public List<AccommodationSummaryProjection> findAllSummary() {
        return accommodationService.findAllSummary();
    }

    @Override
    public List<AccommodationDetailedProjection> findAllDetailed() {
        return accommodationService.findAllDetailed();
    }

    @Override
    public List<AccommodationView> findAllViews() {
        return accommodationViewService.findAll();
    }

    @Override
    public List<AccommodationStatsView> findAllStats() {
        return accommodationStatsViewService.findAll();
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
