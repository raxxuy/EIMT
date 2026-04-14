package mk.ukim.finki.emc.lab.repository;

import mk.ukim.finki.emc.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationStatsViewRepository extends JpaRepository<AccommodationStatsView, AccommodationCategory> {
    @Modifying
    @Query(value = "call refresh_accommodation_stats_view()", nativeQuery = true)
    void refresh();
}