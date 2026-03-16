package mk.ukim.finki.emc.lab.service.application;

import mk.ukim.finki.emc.lab.model.dto.CreateHostDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayHostDto;

import java.util.List;

public interface HostApplicationService {
    DisplayHostDto findById(Long id);

    List<DisplayHostDto> findAll();

    DisplayHostDto create(CreateHostDto createHostDto);

    DisplayHostDto update(Long id, CreateHostDto createHostDto);

    DisplayHostDto deleteById(Long id);
}
