package mk.ukim.finki.emc.lab.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;

public interface AccommodationDetailedProjection {
    Long getId();

    String getName();

    AccommodationCategory getCategory();

    Integer getNumRooms();

    @JsonIgnore
    HostInfo getHost();

    interface HostInfo {
        String getName();

        String getSurname();

        CountryInfo getCountry();

        interface CountryInfo {
            String getName();
        }
    }

    default String getHostFullName() {
        return getHost().getName() + " " + getHost().getSurname();
    }

    default String getCountry() {
        return getHost().getCountry().getName();
    }
}