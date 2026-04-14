package mk.ukim.finki.emc.lab.repository;

import mk.ukim.finki.emc.lab.model.domain.Accommodation;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>, JpaSpecificationExecutor<Accommodation> {
    List<AccommodationSummaryProjection> findAllSummaryBy();

    List<AccommodationDetailedProjection> findAllDetailedBy();

    @EntityGraph(value = "accommodation-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Accommodation> findWithHostAndCountryById(Long id);
}
