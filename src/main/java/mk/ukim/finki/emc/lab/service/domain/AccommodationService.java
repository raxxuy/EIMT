package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccommodationService {
    Accommodation findById(Long id);

    Accommodation findWithHostAndCountryById(Long id);

    List<Accommodation> findAll();

    Page<Accommodation> findAll(FilterAccommodationDto filter, int page, int size, String sortBy);

    List<AccommodationSummaryProjection> findAllSummary();

    List<AccommodationDetailedProjection> findAllDetailed();

    Accommodation create(Accommodation accommodation);

    Accommodation update(Long id, Accommodation accommodation);

    Accommodation deleteById(Long id);

    Accommodation markAsRented(Long id);
}
