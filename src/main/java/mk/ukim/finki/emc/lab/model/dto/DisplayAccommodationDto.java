package mk.ukim.finki.emc.lab.model.dto;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;

import java.util.List;
import java.util.stream.IntStream;

public record DisplayAccommodationDto(
        Long id,
        String name,
        AccommodationCategory category,
        AccommodationCondition condition,
        Boolean rented,
        Integer numRooms,
        String hostFullName,
        String country,
        Double averageRating
) {
    public static DisplayAccommodationDto from(Accommodation accommodation, Double averageRating) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getCondition(),
                accommodation.isRented(),
                accommodation.getNumRooms(),
                "%s %s".formatted(accommodation.getHost().getName(), accommodation.getHost().getSurname()),
                accommodation.getHost().getCountry().getName(),
                averageRating
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations, List<Double> averageRatings) {
        return IntStream.range(0, accommodations.size())
                .mapToObj(i -> from(accommodations.get(i), averageRatings.get(i)))
                .toList();
    }
}