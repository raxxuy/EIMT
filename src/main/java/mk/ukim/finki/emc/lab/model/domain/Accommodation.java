package mk.ukim.finki.emc.lab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.emc.lab.model.enums.AccommodationCondition;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accommodations")
public class Accommodation extends BaseAuditableEntity {
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccommodationCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccommodationCondition condition = AccommodationCondition.GOOD;

    @Column(nullable = false)
    private boolean rented = false;

    @Column(nullable = false)
    private Integer numRooms;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    public Accommodation(String name, AccommodationCategory category, AccommodationCondition condition, Host host, Integer numRooms, boolean rented) {
        this.name = name;
        this.category = category;
        this.condition = condition;
        this.host = host;
        this.numRooms = numRooms;
        this.rented = rented;
    }
}
