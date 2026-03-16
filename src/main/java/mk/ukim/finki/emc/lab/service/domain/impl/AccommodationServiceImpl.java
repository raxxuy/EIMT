package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotAvailableException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.emc.lab.repository.AccommodationRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
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
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id)
                .map(existing -> {
                    existing.setName(accommodation.getName());
                    existing.setCategory(accommodation.getCategory());
                    existing.setCondition(accommodation.getCondition());
                    existing.setHost(accommodation.getHost());
                    existing.setNumRooms(accommodation.getNumRooms());
                    return accommodationRepository.save(existing);
                });
    }

    @Override
    public Optional<Accommodation> deleteById(Long id) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        accommodation.ifPresent(existing -> {
            if (existing.getCondition() != AccommodationCondition.BAD || existing.isRented()) {
                throw new AccommodationNotAvailableException(id);
            }
            accommodationRepository.delete(existing);
        });
        return accommodation;
    }

    @Override
    public Accommodation markAsRented(Long id) {
        Accommodation accommodation = findById(id).orElseThrow(() -> new AccommodationNotFoundException(id));

        if (accommodation.isRented()) {
            throw new AccommodationNotAvailableException(id);
        }

        accommodation.setRented(Boolean.TRUE);
        return accommodationRepository.save(accommodation);
    }
}
