package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;

public record FilterAccommodationDto(
        AccommodationCategory category,
        Long hostId,
        Long countryId,
        Integer numRooms,
        Boolean available
) {}