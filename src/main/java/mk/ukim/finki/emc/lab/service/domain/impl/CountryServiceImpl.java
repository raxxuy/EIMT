package mk.ukim.finki.emc.lab.service.domain.impl;

import mk.ukim.finki.emc.lab.model.domain.Country;
import mk.ukim.finki.emc.lab.model.exception.CountryNotFoundException;
import mk.ukim.finki.emc.lab.repository.CountryRepository;
import mk.ukim.finki.emc.lab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return countryRepository
                .findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}

