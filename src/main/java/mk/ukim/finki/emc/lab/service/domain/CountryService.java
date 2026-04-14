package mk.ukim.finki.emc.lab.service.domain;

import mk.ukim.finki.emc.lab.model.domain.Country;

import java.util.List;

public interface CountryService {
    Country findById(Long id);

    List<Country> findAll();
}
