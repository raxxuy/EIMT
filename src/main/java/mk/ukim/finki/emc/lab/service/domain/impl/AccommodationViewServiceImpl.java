package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.view.AccommodationView;
import mk.ukim.finki.emc.lab.repository.AccommodationViewRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationViewServiceImpl implements AccommodationViewService {
    private final AccommodationViewRepository accommodationViewRepository;

    public AccommodationViewServiceImpl(AccommodationViewRepository accommodationViewRepository) {
        this.accommodationViewRepository = accommodationViewRepository;
    }

    @Override
    public List<AccommodationView> findAll() {
        return accommodationViewRepository.findAll();
    }
}
