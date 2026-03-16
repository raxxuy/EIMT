package mk.ukim.finki.emc.lab.repository;

import mk.ukim.finki.emc.lab.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
