package mk.ukim.finki.emc.lab.repository;

import mk.ukim.finki.emc.lab.model.view.AccommodationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationViewRepository extends JpaRepository<AccommodationView, Long> {
}
