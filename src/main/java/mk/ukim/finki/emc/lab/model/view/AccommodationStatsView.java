package mk.ukim.finki.emc.lab.model.view;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "accommodation_stats_view")
public class AccommodationStatsView {
    @Id
    @Enumerated(EnumType.STRING)
    private AccommodationCategory category;

    private Long totalAccommodations;

    private Long totalRooms;

    private Double averageRooms;
}
