package mk.ukim.finki.emc.lab.service.application;

import mk.ukim.finki.emc.lab.model.dto.CreateCountryDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayCountryDto;

import java.util.List;

public interface CountryApplicationService {
    DisplayCountryDto findById(Long id);

    List<DisplayCountryDto> findAll();

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    DisplayCountryDto update(Long id, CreateCountryDto createCountryDto);

    DisplayCountryDto deleteById(Long id);
}
