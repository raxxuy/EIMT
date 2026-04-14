package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import mk.ukim.finki.emc.lab.repository.AccommodationActivityLogRepository;
import mk.ukim.finki.emc.lab.service.domain.AccommodationActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccommodationActivityLogServiceImpl implements AccommodationActivityLogService {
    private final AccommodationActivityLogRepository accommodationActivityLogRepository;

    public AccommodationActivityLogServiceImpl(AccommodationActivityLogRepository accommodationActivityLogRepository) {
        this.accommodationActivityLogRepository = accommodationActivityLogRepository;
    }

    @Override
    public Page<AccommodationActivityLog> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return accommodationActivityLogRepository.findAll(pageable);
    }

    @Override
    public AccommodationActivityLog create(AccommodationActivityLog accommodationActivityLog) {
        return accommodationActivityLogRepository.save(accommodationActivityLog);
    }
}
