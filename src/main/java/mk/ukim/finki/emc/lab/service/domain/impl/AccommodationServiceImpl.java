package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;
import mk.ukim.finki.emc.lab.model.exception.AccommodationDeletionNotAllowedException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotAvailableException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.emc.lab.repository.AccommodationRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository
                .findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
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
    public Accommodation markAsRented(Long id) {
        Accommodation accommodation = findById(id);

        if (accommodation.isRented()) {
            throw new AccommodationNotAvailableException(id);
        }

        accommodation.setRented(true);
        return accommodationRepository.save(accommodation);
    }
}
