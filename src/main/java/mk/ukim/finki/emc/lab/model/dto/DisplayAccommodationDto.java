package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;

import java.util.List;

public record DisplayAccommodationDto(
        Long id,
        String name,
        AccommodationCategory category,
        AccommodationCondition condition,
        Boolean rented,
        Integer numRooms,
        String hostFullName,
        String country
) {
    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getCondition(),
                accommodation.isRented(),
                accommodation.getNumRooms(),
                "%s %s".formatted(accommodation.getHost().getName(), accommodation.getHost().getSurname()),
                accommodation.getHost().getCountry().getName()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> categories) {
        return categories
                .stream()
                .map(DisplayAccommodationDto::from)
                .toList();
    }
}