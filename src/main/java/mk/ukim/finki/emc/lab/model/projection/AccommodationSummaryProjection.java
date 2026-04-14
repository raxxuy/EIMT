package mk.ukim.finki.emc.lab.model.projection;

import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;

public interface AccommodationSummaryProjection {
    Long getId();

    String getName();

    AccommodationCategory getCategory();

    Integer getNumRooms();
}