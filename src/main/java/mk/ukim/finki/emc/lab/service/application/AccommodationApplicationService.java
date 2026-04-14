package mk.ukim.finki.emc.lab.service.application;

import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayReviewDto;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;
import mk.ukim.finki.emc.lab.model.view.AccommodationView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccommodationApplicationService {
    DisplayAccommodationDto findById(Long id);

    DisplayAccommodationDto findWithHostAndCountryById(Long id);

    List<DisplayAccommodationDto> findAll();

    Page<DisplayAccommodationDto> findAll(FilterAccommodationDto filter, int page, int size, String sortBy);

    Page<AccommodationActivityLog> findAllActivityLogs(int page, int size, String sortBy);

    List<AccommodationSummaryProjection> findAllSummary();

    List<AccommodationDetailedProjection> findAllDetailed();

    List<AccommodationView> findAllViews();

    List<AccommodationStatsView> findAllStats();

    List<DisplayReviewDto> findAllReviews(Long id);

    DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto);

    DisplayAccommodationDto update(Long id, CreateAccommodationDto createAccommodationDto);

    DisplayAccommodationDto deleteById(Long id);

    DisplayAccommodationDto markAsRented(Long id);
}