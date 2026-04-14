package mk.ukim.finki.emc.lab.model.view;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "accommodation_view")
public class AccommodationView {
    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccommodationCategory category;

    private Integer numRooms;

    private String hostFullName;

    private String country;
}
