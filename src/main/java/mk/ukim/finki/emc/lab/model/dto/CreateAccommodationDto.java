package mk.ukim.finki.emc.lab.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.emc.lab.model.domain.Host;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;

public record CreateAccommodationDto(
        @NotBlank(message = "Name must not be blank.")
        String name,
        @NotNull(message = "Category must not be null.")
        AccommodationCategory category,
        @NotNull(message = "Condition must not be null.")
        AccommodationCondition condition,
        @NotNull(message = "Host ID must not be null.")
        Long hostId,
        @Positive
        Integer numRooms,
        boolean rented
) {
    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, condition, host, numRooms, rented);
    }
}