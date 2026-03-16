package mk.ukim.finki.emc.lab.service.application.impl;

import mk.ukim.finki.emc.lab.model.domain.Country;
import mk.ukim.finki.emc.lab.model.dto.CreateHostDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.emc.lab.service.application.HostApplicationService;
import mk.ukim.finki.emc.lab.service.domain.CountryService;
import mk.ukim.finki.emc.lab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }

    @Override
    public DisplayHostDto findById(Long id) {
        return DisplayHostDto.from(hostService.findById(id));
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public DisplayHostDto create(CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.countryId());
        return DisplayHostDto.from(hostService.create(createHostDto.toHost(country)));
    }

    @Override
    public DisplayHostDto update(Long id, CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.countryId());
        return DisplayHostDto.from(hostService.update(id, createHostDto.toHost(country)));
    }

    @Override
    public DisplayHostDto deleteById(Long id) {
        return DisplayHostDto.from(hostService.deleteById(id));
    }
}
