package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.domain.Country;

public record CreateCountryDto(
        String name,
        String continent
) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}