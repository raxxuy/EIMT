package mk.ukim.finki.emc.lab.service.application;

import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayReviewDto;

import java.util.List;

public interface AccommodationApplicationService {
    DisplayAccommodationDto findById(Long id);

    List<DisplayAccommodationDto> findAll();

    List<DisplayReviewDto> findAllReviews(Long id);

    DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto);

    DisplayAccommodationDto update(Long id, CreateAccommodationDto createAccommodationDto);

    DisplayAccommodationDto deleteById(Long id);

    DisplayAccommodationDto markAsRented(Long id);
}