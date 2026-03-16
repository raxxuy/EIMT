package mk.ukim.finki.emc.lab.service.application.impl;

import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import mk.ukim.finki.emc.lab.service.domain.AccommodationService;
import mk.ukim.finki.emc.lab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public DisplayAccommodationDto findById(Long id) {
        return DisplayAccommodationDto.from(accommodationService.findById(id));
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId());
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto.toAccommodation(host)));
    }

    @Override
    public DisplayAccommodationDto update(Long id, CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId());
        return DisplayAccommodationDto.from(accommodationService.update(id, createAccommodationDto.toAccommodation(host)));
    }

    @Override
    public DisplayAccommodationDto deleteById(Long id) {
        return DisplayAccommodationDto.from(accommodationService.deleteById(id));
    }

    @Override
    public DisplayAccommodationDto markAsRented(Long id) {
        return DisplayAccommodationDto.from(accommodationService.markAsRented(id));
    }
}
