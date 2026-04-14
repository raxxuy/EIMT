package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;
import mk.ukim.finki.emc.lab.repository.AccommodationStatsViewRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationStatsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationStatsViewServiceImpl implements AccommodationStatsViewService {
    private final AccommodationStatsViewRepository accommodationStatsViewRepository;

    public AccommodationStatsViewServiceImpl(AccommodationStatsViewRepository accommodationStatsViewRepository) {
        this.accommodationStatsViewRepository = accommodationStatsViewRepository;
    }

    @Override
    public List<AccommodationStatsView> findAll() {
        return accommodationStatsViewRepository.findAll();
    }
}
