package mk.ukim.finki.emc.lab.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "accommodation_activity_log")
public class AccommodationActivityLog extends BaseAuditableEntity {
    @Column(nullable = false)
    private Long accommodationId;

    @Column(nullable = false)
    private String accommodationName;

    @Column(nullable = false)
    private String eventType;

    public AccommodationActivityLog(Long accommodationId, String accommodationName, String eventType) {
        this.accommodationId = accommodationId;
        this.accommodationName = accommodationName;
        this.eventType = eventType;
    }
}
