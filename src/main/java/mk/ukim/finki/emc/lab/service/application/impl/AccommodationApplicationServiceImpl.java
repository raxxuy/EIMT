package mk.ukim.finki.emc.lab.service.application.impl;

import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.exception.HostNotFoundException;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import mk.ukim.finki.emc.lab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService
                .findById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        Host host = hostService
                .findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(createAccommodationDto.hostId()));
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto.toAccommodation(host)));
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Host host = hostService
                .findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(createAccommodationDto.hostId()));
        return accommodationService
                .update(id, createAccommodationDto.toAccommodation(host))
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> deleteById(Long id) {
        return accommodationService
                .deleteById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public DisplayAccommodationDto markAsRented(Long id) {
        return DisplayAccommodationDto.from(accommodationService.markAsRented(id));
    }
}
