package mk.ukim.finki.emc.lab.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emc.lab.event.AccommodationRentedEvent;
import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;
import mk.ukim.finki.emc.lab.model.exception.AccommodationDeletionNotAllowedException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotAvailableException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import mk.ukim.finki.emc.lab.repository.AccommodationRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import mk.ukim.finki.emc.lab.specification.AccommodationSpecification;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.accommodationRepository = accommodationRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository
                .findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }

    @Override
    public Accommodation findWithHostAndCountryById(Long id) {
        return accommodationRepository
                .findWithHostAndCountryById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Page<Accommodation> findAll(FilterAccommodationDto filter, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Specification<Accommodation> spec = AccommodationSpecification.withFilters(filter);
        return accommodationRepository.findAll(spec, pageable);
    }

    @Override
    public List<AccommodationSummaryProjection> findAllSummary() {
        return accommodationRepository.findAllSummaryBy();
    }

    @Override
    public List<AccommodationDetailedProjection> findAllDetailed() {
        return accommodationRepository.findAllDetailedBy();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation update(Long id, Accommodation accommodation) {
        Accommodation existing = findById(id);
        existing.setName(accommodation.getName());
        existing.setCategory(accommodation.getCategory());
        existing.setCondition(accommodation.getCondition());
        existing.setHost(accommodation.getHost());
        existing.setNumRooms(accommodation.getNumRooms());
        return accommodationRepository.save(existing);
    }

    @Override
    public Accommodation deleteById(Long id) {
        Accommodation accommodation = findById(id);

        if (accommodation.getCondition() != AccommodationCondition.BAD || accommodation.isRented()) {
            throw new AccommodationDeletionNotAllowedException(id);
        }

        accommodationRepository.delete(accommodation);
        return accommodation;
    }

    @Override
    @Transactional
    public Accommodation markAsRented(Long id) {
        Accommodation accommodation = findById(id);

        if (accommodation.isRented()) {
            throw new AccommodationNotAvailableException(id);
        }

        accommodation.setRented(true);
        Accommodation saved = accommodationRepository.save(accommodation);
        applicationEventPublisher.publishEvent(new AccommodationRentedEvent(saved));
        return saved;
    }
}
