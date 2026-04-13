package mk.ukim.finki.emc.lab.repository;

import mk.ukim.finki.emc.lab.model.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByAccommodationId(Long accommodationId);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.accommodation.id = :accommodationId")
    Optional<Double> findAverageRatingByAccommodationId(@Param("accommodationId") Long accommodationId);
}
