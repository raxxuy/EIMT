package mk.ukim.finki.emc.lab.specification;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import org.springframework.data.jpa.domain.Specification;

public class AccommodationSpecification {
    public static Specification<Accommodation> withFilters(FilterAccommodationDto filter) {
        return Specification
                .where(hasCategory(filter.category()))
                .and(hasHost(filter.hostId()))
                .and(hasCountry(filter.countryId()))
                .and(hasNumRooms(filter.numRooms()))
                .and(isAvailable(filter.available()));
    }

    private static Specification<Accommodation> hasCategory(AccommodationCategory category) {
        return (root, query, cb) ->
                category == null ? null : cb.equal(root.get("category"), category);
    }

    private static Specification<Accommodation> hasHost(Long hostId) {
        return (root, query, cb) ->
                hostId == null ? null : cb.equal(root.get("host").get("id"), hostId);
    }

    private static Specification<Accommodation> hasCountry(Long countryId) {
        return (root, query, cb) ->
                countryId == null ? null : cb.equal(root.get("host").get("country").get("id"), countryId);
    }

    private static Specification<Accommodation> hasNumRooms(Integer numRooms) {
        return (root, query, cb) ->
                numRooms == null ? null : cb.ge(root.get("numRooms"), numRooms);
    }

    private static Specification<Accommodation> isAvailable(Boolean available) {
        return (root, query, cb) ->
                available == null ? null : cb.equal(root.get("rented"), !available);
    }
}